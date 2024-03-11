package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

  public static List<String> splitComma(String input) {
    return Arrays.stream(input.split(",")).collect(Collectors.toList());
  }

  public static void checkLength(String input, int allowedLength) {
    if (input != null && input.length() > allowedLength) {
      throw new RuntimeException(String.format("입력은 %d 이상이어야 합니다.", allowedLength));
    }
  }

}
