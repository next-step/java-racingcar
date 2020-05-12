package step2;

public enum TokenType {

  NUMBER("0"),
  OPERATOR("1");

  private String type;

  TokenType (String type) {
    this.type = type;
  }
}
