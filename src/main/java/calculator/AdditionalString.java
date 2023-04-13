package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalString {
  private static final String DEFAULT_DELIMITER = ",|:";

  private static final int DELIMITER_INDEX = 1;
  private static final int TARGET_INDEX = 2;

  private static final String EMPTY = "";

  private final String value;
  private final Pattern pattern;

  AdditionalString(String value) {
    this.value = emptyIfNull(value);
    this.pattern = Pattern.compile("//(.)\\n(.*)");
  }

  public String[] split() {
    if (this.value.isEmpty()) {
      return new String[]{};
    }

    Matcher matcher = this.pattern.matcher(this.value);
    if (!matcher.find()) {
      return this.value.split(DEFAULT_DELIMITER);
    }

    String delimiter = this.DEFAULT_DELIMITER + "|" + matcher.group(DELIMITER_INDEX);
    return matcher.group(TARGET_INDEX)
        .split(delimiter);
  }

  private String emptyIfNull(String value) {
    return Objects.isNull(value) ? EMPTY : value;
  }
}
