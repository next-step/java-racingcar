package racing.model;

import java.util.regex.Pattern;

public class RaceCount {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^-?[0-9]+$)");

    private final int raceCount;

    public RaceCount(final String raceCount) {
        validate(raceCount);

        this.raceCount = Integer.parseInt(raceCount);
    }

    private void validate(final String raceCount) {
        if (containsNotNumeric(raceCount) || isNotPositive(Integer.parseInt(raceCount))) {
            throw new IllegalArgumentException("이동횟수는 양의 정수만 입력할 수 있습니다.");
        }
    }

    private boolean containsNotNumeric(final String raceCount) {
        return !NUMBER_PATTERN.matcher(raceCount).find();
    }

    private boolean isNotPositive(final int raceCount) {
        return raceCount <= 0;
    }

    public int toInt() {
        return raceCount;
    }

}
