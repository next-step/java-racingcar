import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

  private static final String BASE_DELIMITER = ",|:";
  private static final String DELIMITER_PATTERN = "//(.)\n(.*)";

  public static String[] tokenize(String source) {
    if (isSplitCustom(source, DELIMITER_PATTERN)) {
      return splitCustom(source, DELIMITER_PATTERN);
    }

    return source.split(BASE_DELIMITER);
  }

  private static boolean isSplitCustom(String source, String regex) {
    return Pattern.compile(regex).matcher(source).find();
  }

  private static String[] splitCustom(String source, String regex) {
    if (!isSplitCustom(source, regex)) {
      return null;
    }

    Matcher m = Pattern.compile(regex).matcher(source);
    String customDelimiter = m.group(1);
    return m.group(2).split(customDelimiter);
  }
}
