package ama.authenticator.userlogin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * a model representing user - this will also be a database table with all fields as columns
 */
@Entity
@Table(name = "user")
public class User {

  public User() {
  }

  public User(String userName, String firstName, String lastName,
      String occupation, char[] password) {
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.occupation = occupation;
  }

  @Id
  private String userName;

  private char[] password;

  private String firstName;

  private String lastName;

  private String occupation;

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public char[] getPassword() {
    return password;
  }
}
