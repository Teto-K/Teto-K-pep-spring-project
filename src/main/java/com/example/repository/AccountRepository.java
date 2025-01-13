package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account save(Account account);
    Account findByUsernameAndPassword(String username, String password);
    Account findByAccountId(int accountId);
    List<Account> findAll();
}
