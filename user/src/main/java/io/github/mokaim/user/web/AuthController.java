package io.github.mokaim.user.web;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@RestController
public class AuthController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/test")
  public ResponseEntity<String> hello(HttpServletRequest request) {
    Locale locale = request.getLocale();

    System.out.println("currnet locale : " + locale);
    HttpSession session = request.getSession();
    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);

    return new ResponseEntity<>(messageSource.getMessage("test", new Object[]{"moka"},"default", locale), HttpStatus.OK);
  }
}
