package com.hermans.jsonviews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.hermans.jsonviews.entity.User;
import com.hermans.jsonviews.jackson.UserViews;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Jackson Configuration
 *
 * Maxxton Group 2016
 *
 * @author Robin Hermans (info@robinhermans.net)
 */
@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

  private User user = new User("John", "Do", "johndo@mail.com");

  @JsonView(UserViews.UserBasics.class)
  @RequestMapping(method = RequestMethod.GET)
  public User viewProfile() {
    return user;
  }

  @JsonView(UserViews.UserDetails.class)
  @RequestMapping(method = RequestMethod.GET, path = "/details")
  public User viewProfileDetails() {
    return user;
  }
}
