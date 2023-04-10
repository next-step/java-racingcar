package calculator;

import static calculator.constant.SplitAndSumConstant.CUSTOM_SEPARATOR_GROUP;
import static calculator.constant.SplitAndSumConstant.CUSTOM_SEPARATOR_PATTERN;
import static calculator.constant.SplitAndSumConstant.DEFAULT_SEPARATOR_LIST;

import calculator.dto.SplitAndSumParameter;
import calculator.validator.PositiveDigitOnlyValidator;
import calculator.validator.SplitArgumentValidator;
import java.util.Arrays;
import java.util.List;
import util.ImmutableListUtils;
import util.RegExUtils;
import util.StringUtils;

public class StringAddCalculator {
  private static final List<SplitArgumentValidator> splitValidatorList;

  static {
    splitValidatorList = List.of(new PositiveDigitOnlyValidator());
  }

  public static int splitAndSum (final String input) {
    if (StringUtils.isBlank(input)) {
      return 0;
    }

    SplitAndSumParameter calculateParam = parseAndGetParameterInfo(input);
    String[] arguments = calculateParam.getArguments();
    validateAllArguments(arguments);

    return Arrays.stream(arguments)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static void validateAllArguments(String[] spllitedArgs) {
    for (SplitArgumentValidator splitValidator : splitValidatorList) {
      splitValidator.validate(spllitedArgs);
    }
  }

  private static SplitAndSumParameter parseAndGetParameterInfo(String input) {
    final String customSeparator = RegExUtils.extractGroup(input, CUSTOM_SEPARATOR_PATTERN, CUSTOM_SEPARATOR_GROUP);

    final boolean hasCustomSeparator = StringUtils.isNotBlank(customSeparator);
    if (hasCustomSeparator) {
      String replacedInput = replaceArgumentChunk(input, customSeparator);
      return new SplitAndSumParameter(replacedInput, ImmutableListUtils.appendOneWith(DEFAULT_SEPARATOR_LIST, customSeparator));
    }
    return new SplitAndSumParameter(input, DEFAULT_SEPARATOR_LIST);
  }

  private static String replaceArgumentChunk(String input, String customSeparator) {
    return input.replaceFirst(String.format("//%s\n", customSeparator), "");
  }
}
