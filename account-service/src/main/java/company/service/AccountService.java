package company.service;

import company.dto.AccountDTO;
import company.dto.converter.AccountDTOConverter;
import company.dto.request.CreateAccountDTORequest;
import company.dto.request.UpdateAccountDTORequest;
import company.exception.AccountExistException;
import company.exception.AccountNotFoundException;
import company.model.Account;
import company.repository.AccountRepository;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDTOConverter accountDTOConverter;

    public AccountDTO createUser(CreateAccountDTORequest createAccountDTORequest) {

        validateAccount(createAccountDTORequest.getEmail(),
                createAccountDTORequest.getUsername(), createAccountDTORequest.getPhone());

        Account account = new Account();

        account.setName(createAccountDTORequest.getName());
        account.setSurname(createAccountDTORequest.getSurname());
        account.setUsername(createAccountDTORequest.getUsername());
        account.setName(createAccountDTORequest.getName());
        account.setEmail(createAccountDTORequest.getEmail());
        account.setPhoneNumber(createAccountDTORequest.getPhone());
        account.setPassword(createAccountDTORequest.getPassword());
        account.setIsActive(false);

        return accountDTOConverter.convert(accountRepository.save(account));
    }

    public List<AccountDTO> getAllAccount() {
        return accountDTOConverter.convert(accountRepository.findAll());
    }


    public AccountDTO updateAccount(Long id, UpdateAccountDTORequest updateAccountDTORequest) {

        if (accountRepository.existsById(id) == false) {
            throw new AccountNotFoundException("User couldn't be found by following id:");
        }

        validateAccount(updateAccountDTORequest.getEmail(),
                updateAccountDTORequest.getUsername(), updateAccountDTORequest.getPhone());

        Account account = new Account();
        account.setId(id);
        account.setName(updateAccountDTORequest.getName());
        account.setSurname(updateAccountDTORequest.getSurname());
        account.setUsername(updateAccountDTORequest.getUsername());
        account.setEmail(updateAccountDTORequest.getEmail());
        account.setPhoneNumber(updateAccountDTORequest.getPhone());
        account.setPassword(updateAccountDTORequest.getPassword());

        return accountDTOConverter.convert(accountRepository.save(account));
    }


    private Account getAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public AccountDTO getAccountById(Long id) {
        return accountDTOConverter.convert(accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account couldn't be found by following id: " + id)));
    }


    private Account getUserByPhoneNumber(String phoneNumber) {
        return accountRepository.findAccountByPhoneNumber(phoneNumber);
    }

    public AccountDTO findAccountByUsername(String username) {
        return accountDTOConverter.convert(
                accountRepository.findAccountByUsername(username).orElseThrow(() ->
                        new AccountNotFoundException("Account couldn't be found by following username: " + username)));
    }


    private void validateAccount(String email, String username, String phoneNumber) {

        if (accountRepository.existsByUsername(username))
            throw new AccountExistException("Account exist by following username");

        if (accountRepository.existsByEmail(email))
            throw new AccountExistException("Account exist by following email");

        if (accountRepository.existsByPhoneNumber(phoneNumber))
            throw new AccountExistException("Account exist by following phone number");
    }

    public void deleteAccount(Long userId) {
        accountRepository.deleteById(userId);
    }

    public void deactiveAccount(Long userId) {
        //TODO
    }

    public void activeAccount(Long id) {
        //TODO
    }
}
