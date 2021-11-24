import java.util.List;

public class Strings {

  public static boolean isBlank(String input) {
    return input == null || input.trim().isEmpty();
  }

  public static String join(List<String> strings, String delimiter) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String element : strings) {
      append(stringBuilder, element, delimiter);
    }
    return stringBuilder.toString();
  }

  private static void append(StringBuilder stringBuilder, String element, String delimiter) {
    if (stringBuilder.length() > 0) {
      stringBuilder.append(delimiter);
    }
    stringBuilder.append(element);
  }

}