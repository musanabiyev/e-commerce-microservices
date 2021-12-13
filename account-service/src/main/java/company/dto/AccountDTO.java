package company.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;
    private Boolean isActive;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String name, String surname, String username, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AccountDTO(
            Long id, String name, String surname, String username, String email,
            String phoneNumber, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

}
