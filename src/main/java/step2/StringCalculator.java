package step2;

public class StringCalculator {
  
  public int calculate(String input) {
    String[] splitInputs = getSplitInputs(input);
    validateInputs(splitInputs);
    return execute(splitInputs);
  }
  
  /**
   * 입력값 나누기
   * @param input
   * @return
   */
  private String[] getSplitInputs(String input) {
    input = input.trim();
    if (input.length() == 0){
      throw new IllegalArgumentException("입력값이 비어있습니다.");
    }
    return input.split(" ");
  }
  
  /**
   * 입력값 갯수 확인 - 최소 3개 이상 & 홀수여야 한다
   * @param inputs
   */
  public static void validateInputs(String[] inputs) {
    int size = inputs.length;
    if (size < 3 || size % 2 != 1) {
      throw new IllegalArgumentException("입력값 갯수가 너무 적거나 잘못되었습니다.");
    }
  }
  
  /**
   * 계산
   * @param inputs
   * @return
   */
  public int execute(String[] inputs) {
    int result = Integer.parseInt(inputs[0]);
    for (int i = 1; i < inputs.length - 1; i += 2) {
      int num = Integer.parseInt(inputs[i + 1]);
      result = Operator.calculation(inputs[i], result, num);
    }
    return result;
  }
}
