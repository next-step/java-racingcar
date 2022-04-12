package camp.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  기능 요구사항
  쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
  앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

  프로그래밍 요구사항
  메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
*/
public class StringAddCalculator {

  public static final String DEFAULT_DELIMITER = ",|:";
  public static final String CUSTOM_DELIMITER_REGEX = "//(.+)\n(.*)";

  public static int splitAndSum(String input) {
    if (isEmpty(input)) {
      return 0;
    }
    return sum(toInt(split(input)));
  }

  private static boolean isEmpty(String input) {
    return input == null || input.length() < 1;
  }

  private static String[] split(String input) {
    Pattern r = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    Matcher matcher = r.matcher(input);
    if (!matcher.find()) {
      return input.split(DEFAULT_DELIMITER);
    }

    String delimiter = matcher.group(1);
    return matcher.group(2).split(delimiter);
  }

  private static int[] toInt(String[] strings) {
    int[] result = new int[strings.length];
    int index = 0;
    for (String str : strings) {
      result[index] = new PositiveNumber(str).getNumber();
      index++;
    }
    return result;
  }

  private static int sum(int[] numbers) {
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }

}
