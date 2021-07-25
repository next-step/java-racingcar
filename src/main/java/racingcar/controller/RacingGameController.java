package racingcar.controller;

import racingcar.controller.dto.CarRequestDto;
import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.Cars;
import racingcar.rules.RandomRule;
import racingcar.rules.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {

    public List<RacingGameResponseDto> racingGameStart(CarRequestDto carRequestDto) {

        final List<String> names = Arrays.asList(carRequestDto.getNames().split(","));
        final int numberOfAttempts = parseInt(carRequestDto.getNumberOfAttempts());

        Cars cars = new Cars(names);

        List<RacingGameResponseDto> response = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts; i++) {
            Rule rule = new RandomRule();
            cars = cars.move(rule);
            response.add(new RacingGameResponseDto(CarResponseDto.toDtos(cars), i == numberOfAttempts - 1));
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
