package io.github.mokaim.user.config;



import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


/* 메시지 국제화를 위한 설정
 * 클라이언트에 따른 다국어 기능을 활용하기위한 필수 매개값으로 클라이언트의 로케일(국가 및 국가의 시간정보등)이 필요하다.
 * Spring Boot 자동설정에 사용자 브라우저 언어에 따라 로케일 설정을 가져오는 AcceptHeaderLocaleResolver 가 자동적으로 등록되기에 별도 설정을 필요하지 않다.
 * <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-localeresolver">LocaleResolver</a>
 */
@Configuration
public class InternationalizationConfig {
  /*
   * MessageFormat 에서 제공하는 JDK 표준 메시지 구문분석 기능과함께 ResourceBundle 구현을 기반으로하는
   * ResourceBundleMessageSource 를 빈으로 등록한다.
   * <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ResourceBundleMessageSource.html">ResourceBundleMessageSource</a>
   */
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("message");
    return messageSource;
  }
}
