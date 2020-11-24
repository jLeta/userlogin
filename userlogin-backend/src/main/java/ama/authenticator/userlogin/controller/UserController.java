package ama.authenticator.userlogin.controller;

import ama.authenticator.userlogin.manager.UserManager;
import ama.authenticator.userlogin.model.LoginRequest;
import ama.authenticator.userlogin.model.User;
import ama.authenticator.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {

  private UserRepository userRepository;

  @Autowired
  private UserManager userManager;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/login")
  public ResponseEntity<User> authenticateUser(@RequestBody LoginRequest loginRequest) {
    User user = userManager.authenticate(loginRequest);
    return user == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok().body(user);
  }
}
