package stringCalculator;

import java.util.Arrays;

public enum Operation {
  PLUS("+"),MINUS("-"),MULTIPLE("*"),DIVIDE("/");

  private String code;

  Operation(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public static Operation ofCode(String code) {
    return Arrays.stream(values())
        .filter( op -> op.getCode().equals(code))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("input not contains operation"));
  }
}
