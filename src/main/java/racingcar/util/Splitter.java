package racingcar.util;

public class Splitter {

    private static final String DEFAULT_SPLIT_REGEX = ",";

    private Splitter() {
    }

    public static String[] splitString(String inputStrings) {
        validate(inputStrings);
        return inputStrings.split(DEFAULT_SPLIT_REGEX);
    }

    private static void validate(String inputStrings) {
        if (inputStrings == null || inputStrings.isBlank()) {
            throw new IllegalArgumentException("최소 한 글자 이상을 입력해야 합니다.");
        }
    }
}
