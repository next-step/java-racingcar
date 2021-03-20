package study1.winner.code.service;

import java.util.Objects;

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


  @Override
    public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (!(o instanceof Name)) {
          return false;
        }
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

}
