package company.dto.converter;

import company.dto.AccountDTO;
import company.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountDTOConverter {
    public AccountDTO convert(Account from) {
        return new AccountDTO(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getUsername(),
                from.getEmail(),
                from.getPhoneNumber(),
                from.getIsActive());
    }

    public List<AccountDTO> convert(List<Account> fromList) {

        return fromList.stream().map(from -> new AccountDTO(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getUsername(),
                from.getEmail(),
                from.getPhoneNumber(),
                from.getIsActive())).collect(Collectors.toList());
    }
}
