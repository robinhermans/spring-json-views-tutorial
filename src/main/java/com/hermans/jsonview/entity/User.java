package com.hermans.jsonview.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.hermans.jsonview.jackson.UserViews;

/**
 * User entity
 *
 * Maxxton Group 2016
 *
 * @author Robin Hermans (info@hermans.net)
 */
public class User {

  private String firstName;

  @JsonView(UserViews.UserBasics.class)
  private String lastName;

  @JsonView(UserViews.UserDetails.class)
  private String email;

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}