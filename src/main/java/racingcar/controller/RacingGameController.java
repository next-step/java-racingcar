package racingcar.controller;

import racingcar.controller.dto.CarRequestDto;
import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {

    public List<RacingGameResponseDto> racingGameStart(CarRequestDto carRequestDto) {

        final List<String> names = getNames(carRequestDto);
        final int numberOfAttempts = parseInt(carRequestDto.getNumberOfAttempts());

        RacingGame racingGame = new RacingGame(names);

        List<RacingGameResponseDto> response = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts; i++) {
            List<Car> cars = racingGame.start();
            response.add(new RacingGameResponseDto(CarResponseDto.toDtos(cars), i == numberOfAttempts - 1));
        }

        return response;
    }

    private List<String> getNames(CarRequestDto carRequestDto) {
        List<String> names = Arrays.asList(carRequestDto.getNames().split(","));
        boolean isNameLengthOver = names.stream().anyMatch(name -> name.length() > 5);
        if (isNameLengthOver) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
        return names;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수 여야 합니다.");
        }
    }
}
