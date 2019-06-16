package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

  private List<Integer> numbers = new ArrayList<>();

  public Numbers(String[] numbers) {
    this.numbers = convertStringToInteger(separateNumbers(numbers));
  }

  private List<String> separateNumbers(String[] separatedExpression) {
    return Arrays.stream(separatedExpression)
        .filter(value -> isNumber(value))
        .collect(Collectors.toList());
  }

  public static Boolean isNumber(String value) {
    return Pattern.matches("^[0-9]*$", value);
  }

  private List<Integer> convertStringToInteger(List<String> numbers) {
    return numbers.stream().map(number -> Integer.parseInt(number))
        .collect(Collectors.toList());
  }

  public int leftValue() {
    return numbers.get(0);
  }

  public int rightVale() {
    return numbers.get(1);
  }

  public boolean hasNumber() {
    return numbers.size() >= 2;
  }


  public void changeNumberToResult(int result) {
    deleteCalculatedNum();
    insertResult(result);
  }

  private void insertResult(int result) {
    numbers.add(0, result);
  }

  private void deleteCalculatedNum() {
    numbers.remove(0);
    numbers.remove(0);
  }

  public int getResult() {
    return numbers.get(0);
  }
}
