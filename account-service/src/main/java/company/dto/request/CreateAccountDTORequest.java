package company.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CreateAccountDTORequest {

    @NotNull
    @Min(value = 3, message = "name must be at least 3 characters")
    private String name;

    @NotNull
    @Min(value = 3, message = "surname must be at least 3 characters")
    private String surname;

    @NotNull
    @Min(value = 5, message = "username must be at least 5 characters")
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    @Min(value = 6, message = "password must be at least 6 characters")
    private String password;

    public CreateAccountDTORequest() {
    }
}
