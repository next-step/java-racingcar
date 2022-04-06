import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

  public int calculate(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }

    if (str.contains(",")) {
      List<Integer> add = Arrays.stream(str.split(",")).map(Integer::parseInt)
          .collect(Collectors.toList());
      return add.get(0) + add.get(1);
    }
    return Integer.parseInt(str);
  }
}
