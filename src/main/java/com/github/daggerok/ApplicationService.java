package com.github.daggerok;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class ApplicationService {

  public String greeting(String maybeName) {
    final String name = Objects.requireNonNull(maybeName, "maybeName is required");
    return "hello, " + name;
  }
}
