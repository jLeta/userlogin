package ama.authenticator.userlogin.model;

public class LoginRequest {

  String userName;

  char[] password;

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public char[] getPassword() {
    return password;
  }
}
