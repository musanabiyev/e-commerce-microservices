package company.repository;

import company.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByUsername(String username);

    Optional<Account> findById(Long aLong);

    Account findAccountByEmail(String email);

    Account findAccountByUsernameAndPassword(String username, String password);

    Account findAccountByPhoneNumber(String phoneNumber);

    boolean existsById(Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
