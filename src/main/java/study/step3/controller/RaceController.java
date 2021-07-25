package study.step3.controller;

import study.step3.service.RaceService;

import java.util.List;

public class RaceController {

    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public List<List<Integer>> play(int carNumber, int roundNumber) {
        validation(carNumber, roundNumber);
        return raceService.play(carNumber, roundNumber);
    }

    private void validation(int carNumber, int roundNumber) {
        requireGreaterThanZero(carNumber);
        requireGreaterThanZero(roundNumber);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO + number);
        }
    }
}
