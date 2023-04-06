package study.step2;

import java.util.regex.Matcher;

public class CustomMatcher {
  private final Matcher matcher;

  public void findCustomDelimiter() {
    if (!matcher.find()) {
      throw new IllegalArgumentException("커스텀 구분자를 구별할 수 없습니다.");
    }
  }

  public String group(int group) {
    return this.matcher.group(group);
  }

  public static class Builder {

    private Matcher matcher;

    public Builder matcher(Matcher matcher) {
      this.matcher = matcher;
      return this;
    }

    public CustomMatcher build() {
      return new CustomMatcher(this);
    }
  }

  public CustomMatcher(Builder builder) {
    this.matcher = builder.matcher;
  }

}
