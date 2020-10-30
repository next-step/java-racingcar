package step2.validate;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculatorValid {
  private final Pattern pattern = Pattern.compile("(^[0-9]*$)");

  public boolean isNumeric(String data) {
    if (StringUtils.isBlank(data)) {
      return false;
    }
    return pattern.matcher(data).matches();
  }

  public boolean isOperator(String data) {
    List<String> operators = Arrays.asList("+", "-", "*", "/");
    return operators.contains(data);
  }
}
