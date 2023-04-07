package step2;

import java.util.Optional;

public class StringAddCalculator {

    private static final String prefixDynamicSeparatorRegEx = "^//(.)\n";

    private static final String dynamicSeparatorRegEx = prefixDynamicSeparatorRegEx + "(.*)$";

    private static final String defaultSeparator = "[,:]";

    /**
     * 문자열을 입력받아 구분자를 기준으로 분리한 후 각 숫자의 합을 반환<br>
     * 구분자는 쉼표(,) 또는 콜론(:)을 사용할 수 있다.<br>
     * 커스텀 구분자를 지정할 수 있으며 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.<br>
     *
     * @param input 문자열
     * @return 구분자를 기준으로 분리한 후 각 숫자의 합
     */
    public static int splitAndSum(final String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return sum(removePrefixSeparator(input).split(getSeparator(input)));
    }

    private static String getSeparator(final String input) {
        final Optional<String> customSeparator = getIfHasCustomSeparator(input);
        return customSeparator.orElse(defaultSeparator);

    }

    private static Optional<String> getIfHasCustomSeparator(final String input) {
        if (hasCustomSeparator(input)) {
            return Optional.of(input.replaceAll(dynamicSeparatorRegEx, "$1"));
        }
        return Optional.empty();
    }

    private static boolean hasCustomSeparator(final String input) {
        return input.matches(dynamicSeparatorRegEx);
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String s : split) {
            sum += parseOnlyPositive(s);
        }
        return sum;
    }

    private static String removePrefixSeparator(String input) {
        return input.replaceAll(prefixDynamicSeparatorRegEx, "");
    }

    private static int parseOnlyPositive(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
