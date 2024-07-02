package net.revature.projzero.controller;

import net.revature.projzero.model.Account;
import net.revature.projzero.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accService;

    public AccountController(AccountService accService){ this.accService = accService;}

    @PostMapping("register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account acc){
        return ResponseEntity.ok(this.accService.registerNewAccount(acc));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginAccount(@RequestBody Account acc){
        boolean isSuccess = this.accService.loginExistingAccount(acc.getUsername(), acc.getPassword());

        if(isSuccess) return ResponseEntity.ok("Login Successful");
        else return ResponseEntity.badRequest().body("Failed to Login");
    }
}
