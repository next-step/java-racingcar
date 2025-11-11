package study.racing.domain;


import java.util.List;

public class RaceInput {

    private static final String SEPARATOR = ",";

    private final List<String> names;
    private final int numberOfCars;
    private final int numberOfAttempt;

    public RaceInput(String names, int numberOfCars, int numberOfAttempts) {
        validateString(names);
        List<String> splitNames = List.of(names.split(SEPARATOR));
        validateNames(splitNames);
        validateNameAndCarCountMatch(splitNames, numberOfCars);
        this.names = splitNames;

        validateNumber(numberOfCars, numberOfAttempts);
        this.numberOfCars = numberOfCars;
        this.numberOfAttempt = numberOfAttempts;
    }

    private void validateNameAndCarCountMatch(List<String> names, int numberOfCars) {
        if(names.size() != numberOfCars){
            throw new RuntimeException("차량 이름 수와 참가 차량 수가 일치하지 않습니다.");
        }
    }

    private static void validateNumber(int numberOfCars, int numberOfAttempts) {
        if (numberOfCars < 1) {
            throw new RuntimeException("레이스 참가 차량 수는 1대 이상이어야 합니다.");
        }

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

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
