package net.revature.projzero.service;

import net.revature.projzero.model.Account;
import net.revature.projzero.repository.AccountRepository;
import net.revature.projzero.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accRepo;

    public AccountService(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }


    public Account registerNewAccount(Account acc){
        return this.accRepo.save(acc);
    }

    public boolean loginExistingAccount(String username, String password){
        Optional<Account> oppAcc = this.accRepo.findByUsername(username);

        if(oppAcc.isPresent()){
            if(oppAcc.get().getPassword().equals(password)) return true;
        }

        return false;
    }
}
