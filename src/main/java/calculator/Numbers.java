package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

  private final int LEFT_NUM_INDEX = 0;
  private final int RIGHT_NUM_INDEX = 1;
  private final int REQUIRED_FOR_CALCULATION_NUM = 2;
  private final int NUMBERS_DELETE_INDEX = 0;
  private final int RESULT_INSERT_INDEX = 0;
  private final int FINAL_RESULT_INDEX = 0;


  private List<Integer> numbers;

  public Numbers(String[] numbers) {
    this.numbers = convertStringToInteger(separateNumbers(numbers));
  }

  private List<String> separateNumbers(String[] separatedExpression) {
    return Arrays.stream(separatedExpression)
        .filter(value -> isNumber(value))
        .collect(Collectors.toList());
  }

  public static Boolean isNumber(String value) {
    if (isBlank(value)) {
      return false;
    }
    return Pattern.matches("^[0-9]*$", value);
  }

  private static boolean isBlank(String value) {
    return value == null || "".equals(value);
  }

  private List<Integer> convertStringToInteger(List<String> numbers) {
    return numbers.stream().map(number -> Integer.parseInt(number))
        .collect(Collectors.toList());
  }

  public int leftValue() {
    return numbers.get(LEFT_NUM_INDEX);
  }

  public int rightVale() {
    return numbers.get(RIGHT_NUM_INDEX);
  }

  public boolean hasNumber() {
    return numbers.size() >= REQUIRED_FOR_CALCULATION_NUM;
  }


  public void changeNumberToResult(int result) {
    deleteCalculatedNum();
    insertResult(result);
  }

  private void insertResult(int result) {
    numbers.add(RESULT_INSERT_INDEX, result);
  }

  private void deleteCalculatedNum() {
    numbers.remove(NUMBERS_DELETE_INDEX);
    numbers.remove(NUMBERS_DELETE_INDEX);
  }

  public int getResult() {
    return numbers.get(FINAL_RESULT_INDEX);
  }
}
