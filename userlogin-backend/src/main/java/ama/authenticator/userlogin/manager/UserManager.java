package ama.authenticator.userlogin.manager;

import ama.authenticator.userlogin.model.LoginRequest;
import ama.authenticator.userlogin.model.User;
import ama.authenticator.userlogin.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Manager class to do operations on {@link User} entity using {@link UserRepository}.
 */
@Component
public class UserManager {

  private UserRepository userRepository;

  public UserManager(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * returns {@link User} if matching user name and password is found in DB;
   * or else, it returns null to indicate that no matching record found with the user-name and/or password.
   *
   * @param loginRequest
   * @return
   */
  public User authenticate(LoginRequest loginRequest) {
    // validation request ....

    // fetch user using user-name field.
    User user = this.getByUsername(loginRequest.getUserName());
    if (user == null) {
      return null;
    }
    // check if password matches; if it doesn't, return null
    boolean passwordMatched = Arrays.equals(CredentialsManager.hashPassword(loginRequest.getPassword()),
        user.getPassword());

    // at this point the password is used for checking and not needed any more, so remove it from memory
    CredentialsManager.concealPassWordMemory(loginRequest.getPassword());
    // Do not return password to the client.
    user.setPassword(null);

    return passwordMatched ? user : null;
  }

  /**
   * - check if the DB is empty and add a user with admin/admin credential for testing purpose.
   * - return a user matching a given user name.
   *
   * @param userName
   * @return
   */
  private User getByUsername(String userName) {
    // make sure there is data in the H2 in-memory DB
    checkAndInsertToDB();

    Optional<User> optionalUser = userRepository.findById(userName);
    return optionalUser.isPresent() ? optionalUser.get() : null;
  }

  /**
   * if DB is empty initialize with dummy data.
   */
  private void checkAndInsertToDB() {
    List<User> users = userRepository.findAll();
    if (users == null || users.isEmpty()) {
      User user = new User("admin", "Joshua", "Bloch", "Software Engineer",
          "389c537c9ffb94c42d1c16dedbc5e673e18cce3a".toCharArray());
      userRepository.save(user);
    }
  }

}
