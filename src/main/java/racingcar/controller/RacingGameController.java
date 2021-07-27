package racingcar.controller;

import racingcar.controller.dto.RacingGameRequestDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.rules.RandomRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {

    public List<RacingGameResponseDto> start(RacingGameRequestDto racingGameRequestDto) {

        final List<String> names = Arrays.asList(racingGameRequestDto.getNames().split(","));
        final int numberOfAttempts = parseInt(racingGameRequestDto.getNumberOfAttempts());

        RacingGame racingGame = new RacingGame(Cars.of(names), new RandomRule());
        List<RacingGameResponseDto> response = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts; i++) {
            Cars cars = racingGame.next();
            boolean isFinish = i == numberOfAttempts - 1;
            response.add(new RacingGameResponseDto(cars, isFinish));
        }

        return response;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수 여야 합니다.");
        }
    }
}
