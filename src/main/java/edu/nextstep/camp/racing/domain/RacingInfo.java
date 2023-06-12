package edu.nextstep.camp.racing.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingInfo {
    private static final int CAR_MIN_COUNT = 2;
    private static final int CAR_MAX_COUNT = 20;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static final int MOVING_MIN_COUNT = 5;
    private static final int MOVING_MAX_COUNT = 200;

    private final List<String> carNames;
    private final int movingCount;

    private RacingInfo(List<String> carNames, int movingCount) {
        this.carNames = carNames;
        this.movingCount = movingCount;
    }

    public static RacingInfo of(String carNamesString, String movingCount) {
        return of(carNamesString, Integer.parseInt(movingCount));
    }

    public static RacingInfo of(String carNamesString, int movingCount) {
        if (carNamesString == null) {
            throw new IllegalArgumentException("자동차 이름 값이 Null 입니다. ");
        }

        List<String> carNames = Arrays.asList(carNamesString.split(","));

        validationNames(carNames);

        movingCountRangeCheck(movingCount);

        return new RacingInfo(carNames, movingCount);
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public int getMovingCount() {
        return movingCount;
    }

    private static void validationNames(List<String> carNames) {
        for (String carName : carNames) {
            nameLengthCheck(carName);
        }
        nameCountCheck(carNames);
        duplicateNameCheck(carNames);
    }

    private static void nameLengthCheck(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없으며, 5자 이하로 작성 하세요");
        }
    }

    private static void nameCountCheck(List<String> carNames) {
        int carCount = carNames.size();

        if (CAR_MIN_COUNT > carCount || carCount > CAR_MAX_COUNT) {
            throw new IllegalArgumentException("자동차 수는 2~20대로 설정 하세요.");
        }
    }

    private static void duplicateNameCheck(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);

        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }



    private static void movingCountRangeCheck(int movingCount) {
        if (MOVING_MIN_COUNT > movingCount || movingCount > MOVING_MAX_COUNT) {
            throw new IllegalArgumentException("자동차 시도 횟수는 5~200회로 설정 하세요.");
        }
    }


}
