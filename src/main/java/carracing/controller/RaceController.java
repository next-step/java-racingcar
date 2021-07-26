package carracing.controller;

import carracing.domain.RaceResult;
import carracing.service.RaceService;

import java.util.List;
import java.util.Objects;

public class RaceController {

    public static final String NON_NULL_CAR_NAMES = "carNames 리스트 입력값은 null 일 수 없습니다";
    public static final String NOT_EMPTY_CAR_NAMES = "carNames 리스트 입력값은 비어있을 수 없습니다";
    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public RaceResult play(List<String> carNames, int roundNumber) {
        validateCarNames(carNames);
        validateRoundNumber(roundNumber);
        return raceService.play(carNames, roundNumber);
    }

    private void validateCarNames(List<String> carNames) {
        requireNonNull(carNames);
        requireNotEmpty(carNames);
    }

    private void requireNonNull(List<String> carNames) {
        if (Objects.isNull(carNames)) {
            throw new IllegalArgumentException(NON_NULL_CAR_NAMES);
        }
    }

    private void requireNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_CAR_NAMES);
        }
    }

    private void validateRoundNumber(int roundNumber) {
        requireGreaterThanZero(roundNumber);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO + number);
        }
    }
}
