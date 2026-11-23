package racingcar.view;

import racingcar.domain.TryCount;

public class TryCountParser {
    private TryCountParser() {
    }

    public static TryCount parse(String input) {
        validateNotBlank(input);
        return new TryCount(toInt(input.trim()));
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("try count is required");
        }
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("try count must be a number [" + input + "]", e);
        }
    }
}
