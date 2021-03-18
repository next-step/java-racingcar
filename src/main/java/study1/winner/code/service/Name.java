package study1.winner.code.service;

import org.junit.platform.commons.util.StringUtils;

public class Name {  
  private final String name;

  public Name(String name) {
    if(StringUtils.isBlank(name)) {
      throw new IllegalArgumentException("participants should not null or empty");
    }

    this.name = name.trim();
  }

  public String name() {
    return name;
  }
}
