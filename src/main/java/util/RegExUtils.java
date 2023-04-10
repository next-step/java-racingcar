package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtils {

  public static String extractGroup(String input, Pattern pattern, String group) {
    Matcher matcher = pattern.matcher(input);
    if (!matcher.find()) {
      return null;
    }

    try {
      return matcher.group(group);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }
}