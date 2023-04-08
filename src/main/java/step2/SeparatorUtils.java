package step2;

import java.util.Optional;

import static step2.Constant.*;

public class SeparatorUtils {
    private SeparatorUtils() {
    }

    protected static String getSeparator(final String input) {
        final Optional<String> customSeparator = getIfHasCustomSeparator(input);
        return customSeparator.orElse(Constant.defaultSeparator);
    }

    protected static Optional<String> getIfHasCustomSeparator(final String input) {
        if (hasCustomSeparator(input)) {
            return Optional.of(input.replaceAll(dynamicSeparatorRegEx.pattern(), "$1"));
        }
        return Optional.empty();
    }

    protected static boolean hasCustomSeparator(final String input) {
        return dynamicSeparatorRegEx.matcher(input).matches();
    }

    protected static String removePrefixSeparator(String input) {
        return input.replaceAll(prefixDynamicSeparatorRegEx.pattern(), "");
    }

    protected static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
