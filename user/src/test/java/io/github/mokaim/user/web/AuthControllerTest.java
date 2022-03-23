package io.github.mokaim.user.web;

import static org.junit.jupiter.api.Assertions.*;
import io.github.mokaim.common.Response;
import io.github.mokaim.user.config.InternationalizationConfig;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management
//https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-contextconfiguration
@SpringJUnitConfig
@ContextConfiguration(classes = {AuthController.class, Response.class, InternationalizationConfig.class})
class AuthControllerTest {

  MockMvc mockMvc;

  @Autowired
  AuthController authController;

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.authController)
        .alwaysExpect(status().isOk())
        .build();
  }

  @Test
  void getHello() throws Exception {
    Locale locale = Locale.US;
    mockMvc.perform(get("/test?test1={test3}&test2={test4}", "테스트111", "테스트222").accept(MediaType.APPLICATION_JSON)
            .header("Accept-Language", locale.getLanguage() + "-" + locale.getCountry()))
        .andDo(print());
  }

  @Test
  void postHello() {
  }
}