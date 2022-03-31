package io.github.mokaim.user.web;

import io.github.mokaim.common.Response;
import io.github.mokaim.user.service.AuthService;
import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management
//https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-contextconfiguration
/*@SpringJUnitConfig
@ContextConfiguration(classes = {AuthController.class, Response.class, InternationalizationConfig.class})*/
@WebMvcTest(AuthController.class)
//@Transactional
class AuthControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  Response response;

  @MockBean
  AuthService authService;


  @Test
  void getHello() throws Exception {

    Locale locale = Locale.US;
    mockMvc.perform(get("/test?test={test}", "테스트111").accept(MediaType.APPLICATION_JSON)
            .header("Accept-Language", locale.getLanguage() + "-" + locale.getCountry()))
        .andExpect(status().is2xxSuccessful())
        .andDo(print());
  }

  @Test
  void postHello() {

  }
}