package calculator.constant;

import java.util.List;
import java.util.regex.Pattern;

public class SplitAndSumConstant {
  public static final List<String> DEFAULT_SEPARATOR_LIST = List.of(",", ":");
  public static final String CUSTOM_SEPARATOR_GROUP = "separator";
  public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(String.format("//(?<%s>[^\n])", CUSTOM_SEPARATOR_GROUP));
}
