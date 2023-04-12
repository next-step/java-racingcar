package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegExUtils {

  private RegExUtils() {}

  public static final String CUSTOM_SEPARATOR_GROUP = "separator";
  public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(String.format("//(?<%s>[^\n])", CUSTOM_SEPARATOR_GROUP));

  public static String extractCustomDelimiter (String input) {
    Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
    if (!matcher.find()) {
      return null;
    }

    return matcher.group(CUSTOM_SEPARATOR_GROUP);
  }
}