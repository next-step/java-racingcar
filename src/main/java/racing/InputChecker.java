package racing;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class InputChecker {

    private static final String ILLEGAL_CARS = "자동차 이름을 정확히 입력하세요.";
    private static final String ILLEGAL_TRIES = "경주할 거리를 정확히 입력하세요.";
    private static final String INPUT_PATTERN_REGEX = "[\\w]+(,[\\w]+)*";
    private static final Pattern INPUT_PATTERN = Pattern.compile(INPUT_PATTERN_REGEX);
    private static final String DELIMETER = ",";
    private final List<String> names;
    private final int tries;

    InputChecker(String input, int tries) {
        this.names = getValidNames(input);
        this.tries = getValidTries(tries);
    }

    List<String> getNames() {
        return names;
    }

    int getTries() {
        return tries;
    }

    private List<String> getValidNames(String input) {
        if (!isValidNames(input)) {
            throw new IllegalArgumentException(ILLEGAL_CARS);
        }
        return Arrays.asList(input.split(DELIMETER));
    }

    private boolean isValidNames(String names) {
        return INPUT_PATTERN.matcher(names).matches();
    }

    private int getValidTries(int tries) {
        if (tries <= 0) {
            throw new IllegalArgumentException(ILLEGAL_TRIES);
        }
        return tries;
    }
}
