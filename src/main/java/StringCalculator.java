import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

  private String DELIMITER = ",|:";

  public int calculate(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }
    List<Integer> tokens = Arrays.stream(str.split(DELIMITER)).map(Integer::parseInt)
        .collect(Collectors.toList());
    return tokens.stream().reduce(Integer::sum).get();
  }

}
