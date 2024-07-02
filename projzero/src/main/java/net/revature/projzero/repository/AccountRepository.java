package net.revature.projzero.repository;

import jakarta.transaction.Transactional;
import net.revature.projzero.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE username = :username")
    Optional<Account> findByUsername(@Param("username")String username);

}
