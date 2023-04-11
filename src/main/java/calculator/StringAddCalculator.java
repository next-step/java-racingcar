package calculator;

import calculator.dto.SplitAndSumParameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import util.RegExUtils;
import util.StringUtils;

public class StringAddCalculator {

  private StringAddCalculator() {}

  public static final List<String> DEFAULT_DELIMITER_LIST = List.of(",", ":");

  public static int splitAndSum (final String input) {
    if (StringUtils.isBlank(input)) {
      return 0;
    }

    SplitAndSumParameter calculateParam = parseAndGetParameterInfo(input);
    String[] arguments = calculateParam.getArguments();
    validateAllPositiveDigitStr(arguments);

    return Arrays.stream(arguments)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static SplitAndSumParameter parseAndGetParameterInfo (String input) {
    final String customDelimiter = RegExUtils.extractCustomDelimiter(input);

    final boolean hasCustomDelimiter = StringUtils.isNotBlank(customDelimiter);
    if (hasCustomDelimiter) {
      final String replacedInput = replaceArgumentChunk(input, customDelimiter);
      return new SplitAndSumParameter(replacedInput, createCustomDelimiterList(customDelimiter));
    }
    return new SplitAndSumParameter(input, DEFAULT_DELIMITER_LIST);
  }

  private static List<String> createCustomDelimiterList(String customDelimiter) {
    List<String> delimiterList = new ArrayList<>(DEFAULT_DELIMITER_LIST.size() + 1);
    delimiterList.addAll(DEFAULT_DELIMITER_LIST);
    delimiterList.add(customDelimiter);
    return Collections.unmodifiableList(delimiterList);
  }

  private static String replaceArgumentChunk(String input, String customSeparator) {
    return input.replaceFirst(String.format("//%s\n", customSeparator), "");
  }

  private static void validateAllPositiveDigitStr(String[] splittedArgs) {
    for (String splittedArg : splittedArgs) {
      boolean isPositiveDigit = StringUtils.isPositiveDigit(splittedArg);
      if (!isPositiveDigit) {
        throw new RuntimeException();
      }
    }
  }
}
