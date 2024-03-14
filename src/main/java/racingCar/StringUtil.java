package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

  public static List<String> splitComma(String input) {
    return Arrays.stream(input.split(",")).collect(Collectors.toList());
  }



}
