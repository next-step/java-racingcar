package study.racing.domain;

import java.util.List;

public class RaceInput {

    private final List<String> names;
    private final int numberOfAttempt;

    public RaceInput(List<String> names, int numberOfAttempts) {
        validateNames(names);
        this.names = names;

        validateNumber(numberOfAttempts);
        this.numberOfAttempt = numberOfAttempts;
    }

    private static void validateNumber(int numberOfAttempts) {
        if (numberOfAttempts < 1) {
            throw new RuntimeException("레이스 횟수는 1회 이상이어야 합니다.");
        }
    }
    private void validateNames(List<String> names) {
        for (String name : names) {
            validateString(name);
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if (isNameLength(name)) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static void validateString(String names) {
        if (isBlank(names)) {
            throw new RuntimeException("레이스 참가자 이름은 필수입니다.");
        }
    }

    private static boolean isNameLength(String name) {
        return name.length() > 5;
    }

    private static boolean isBlank(String names) {
        return names == null || names.isBlank();
    }


    public List<String> getNames() {
        return names;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
