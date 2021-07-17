package com.tatsam.priorityeng.config;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class RESTAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
    
    super.onAuthenticationFailure(request, response, exception);
  }
}