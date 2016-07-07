package com.hermans.jsonviews;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hermans.jsonviews.controller.ProfileController;
import com.hermans.jsonviews.entity.User;
import com.hermans.jsonviews.jackson.UserViews;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Profile Controller Unit tests
 *
 * Maxxton Group 2016
 *
 * @author Robin Hermans (info@robinhermans.net)
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTests {

  @InjectMocks
  private ProfileController profileController;

  private User testUser;

  private MockMvc mockMvc;

  public static MappingJackson2HttpMessageConverter createJacksonConverter() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
    return converter;
  }

  @Before
  public void setup() {
    testUser = new User("John", "Do", "johndo@mail.com");

    mockMvc = MockMvcBuilders.standaloneSetup(profileController).setMessageConverters(createJacksonConverter()).build();
  }

  @Test
  public void testGetProfile() throws Exception {
    String jsonUser = new ObjectMapper()
      .writerWithView(UserViews.UserBasics.class)
      .writeValueAsString(testUser );

    mockMvc
      .perform(get("/profile")).andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(content().string(jsonUser ));
  }

  @Test
  public void testGetProfileDetails() throws Exception {
    String jsonUser = new ObjectMapper()
      .writerWithView(UserViews.UserDetails.class)
      .writeValueAsString(testUser );

    mockMvc
      .perform(get("/profile/details")).andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(content().string(jsonUser ));
  }

}
