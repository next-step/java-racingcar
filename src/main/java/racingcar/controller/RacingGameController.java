package racingcar.controller;

import racingcar.controller.dto.CarRequestDto;
import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    public List<RacingGameResponseDto> racingGameStart(CarRequestDto carRequestDto) {

        final List<String> names = Arrays.asList(carRequestDto.getNames().split(","));
        final int numberOfAttempts = parseInt(carRequestDto.getNumberOfAttempts());

        RacingGame racingGame = new RacingGame(names);

        List<RacingGameResponseDto> response = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts; i++) {
            List<Car> cars = racingGame.start();
            response.add(new RacingGameResponseDto(getCarResponseDtos(cars), i == numberOfAttempts - 1));
        }

        return response;
    }

    private List<CarResponseDto> getCarResponseDtos(List<Car> cars) {
        return cars.stream()
                .map(CarResponseDto::of)
                .collect(Collectors.toList());
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수 여야 합니다.");
        }
    }
}
