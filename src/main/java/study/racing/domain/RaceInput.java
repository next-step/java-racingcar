package study.racing.domain;


import java.util.List;

public class RaceInput {

    private static final String SEPARATOR = ",";

    private final List<String> names;
    private final int numberOfAttempt;

    public RaceInput(String names, int numberOfAttempts) {
        validateString(names);
        List<String> splitNames = List.of(names.split(SEPARATOR));
        validateNames(splitNames);
        this.names = splitNames;

        validateNumber(numberOfAttempts);
        this.numberOfAttempt = numberOfAttempts;
    }

    private static void validateNumber(int numberOfAttempts) {
        if (numberOfAttempts < 1) {
            throw new RuntimeException("레이스 횟수는 1회 이상이어야 합니다.");
        }
    }

    private void validateString(String names) {
        if (isBlank(names)) {
            throw new RuntimeException("레이스 참가자 이름은 필수입니다.");
        }
    }

    private static boolean isBlank(String names) {
        return names == null || names.isBlank();
    }

    private void validateNames(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new RuntimeException("자동차 이름은 5자를 초과할 수 앖습니다.");
            }
        }
    }

    public List<String> getNames() {
        return names;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
