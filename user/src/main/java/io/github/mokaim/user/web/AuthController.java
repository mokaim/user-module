package io.github.mokaim.user.web;

import io.github.mokaim.common.Response;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private Response response;



  @GetMapping("/test")
  public ResponseEntity<?> getHello(Locale locale) {

    //return response.success("test", new String[]{"firt","second","third"}, locale);
    return response.success("test",  locale);
  }

  @PostMapping("/test")
  public ResponseEntity<?> postHello(Locale locale) {

    //return response.success("test", new String[]{"firt","second","third"}, locale);
    return response.success("test",  locale);
  }
}
