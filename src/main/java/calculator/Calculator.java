package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\n";
  private static final String NUMBER_VALID = "^\\d+$";
  private static final String DEFAULT_DELIMITERS = ",|:";
  private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

  public static int calculate(String text) {
    if(isEmptyOrNull(text)){
      return 0;
    }
    return sumFromStrings(split(text));
  }

  private static boolean isEmptyOrNull(String input){
    return input == null || input.isEmpty();
  }

  private static String[] split(String input){
    String delimiters = DEFAULT_DELIMITERS;

    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
      delimiters += "|" + Pattern.quote(matcher.group(1));
      input = input.substring(matcher.end());
    }
    return input.split(delimiters);
  }

  private static int sum(int[] numbers){
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }

  private static int[] toInts(String[] values){
    int[] ints = new int[values.length];
    for (int i=0; i< values.length; i++){
      ints[i] = Integer.parseInt(numberValidation(values[i]));
    }
    return ints;
  }

  private static int sumFromStrings(String[] values) {
    int result = 0;
    for (String value : values) {
      int number = Integer.parseInt(numberValidation(value));
      result += number;
    }
    return result;
  }

  private static String numberValidation(String value){
    if(!value.matches(NUMBER_VALID)){
      throw new RuntimeException("음수 또는 숫자외의 다른값을 입력하셨습니다.");
    }
    return value;
  }
}

