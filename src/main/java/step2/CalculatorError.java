package step2;

public class CalculatorError {
  private CalculatorError(){ /* 생성자 실행 방지 */ };
  public static String ARGS_NULL = "NULL은 연산이 불가능합니다.";
  public static String ARGS_EMPTY = "공백은 연산이 불가능합니다.";
  public static String INVALID_OPERATOR = "유효하지 않은 연산자입니다.";
}
