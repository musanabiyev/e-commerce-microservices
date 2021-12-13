package company.api;

import company.dto.AccountDTO;
import company.dto.request.CreateAccountDTORequest;
import company.dto.request.UpdateAccountDTORequest;
import company.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountApi {

    private final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/add")
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody CreateAccountDTORequest createAccountDTORequest) {
        return ResponseEntity.ok(accountService.createUser(createAccountDTORequest));
    }

    @PutMapping("/update")
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable(value = "id", required = false) Long id,
            @Valid @RequestBody UpdateAccountDTORequest updateAccountDTORequest) {
        return ResponseEntity.ok(accountService.updateAccount(id, updateAccountDTORequest));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AccountDTO>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable(value = "id", required = true) Long accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<AccountDTO> getAccountByUsername(
            @PathVariable(value = "username", required = true) String username) {
        return ResponseEntity.ok(accountService.findAccountByUsername(username));
    }

    @DeleteMapping("deleteaccount/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable(value = "id", required = true) Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/deactiveaccount/{id}")
    public ResponseEntity<Void> deactiveAccount(@PathVariable(value = "id", required = true) Long accountId) {
        accountService.deactiveAccount(accountId);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/activeaccount/{id}")
    public ResponseEntity<Void> activeAccount(@PathVariable(value = "id", required = true) Long id) {
        accountService.activeAccount(id);
        return ResponseEntity.ok().build();
    }

}
