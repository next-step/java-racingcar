package racing.domain;

import java.util.Arrays;
import java.util.List;

public class InputDto {
    private final List<String> names;
    private final int numberOfAttempts;

    public InputDto(String names, String numberOfAttempts) {
        validation(names);
        this.names = Arrays.asList(names.split(","));
        this.numberOfAttempts = toInteger(numberOfAttempts);
    }

    public List<String> getNames() {
        return names;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void validation(String names) {
        if (isBlank(names))
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
    }

    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
    }

    public static boolean isBlank(String value) {
        return "".equals(value.trim());
    }
}
