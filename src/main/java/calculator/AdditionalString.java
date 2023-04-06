package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalString {
  private static final String DEFAULT_DELIMITER = ",|:";

  private final String value;

  AdditionalString(String value) {
    this.value = nullControlFactory(value);
  }

  public String[] split() {
    if (this.value.isEmpty()) return new String[]{};

    Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(this.value);

    String target = this.value;
    String delimiter = DEFAULT_DELIMITER;
    if(matcher.find()) {
      delimiter += "|" + matcher.group(1);
      target = matcher.group(2);
    }

    return target.split(delimiter);
  }

  private String nullControlFactory(String value) {
    if (value == null) return "";

    return value;
  }
}
