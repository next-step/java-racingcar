package racingcar.controller;

import racingcar.controller.dto.CarResponseDto;
import racingcar.domain.RacingGame;
import racingcar.view.ConsoleView;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleController {

    public void consoleRacingGameStart(String carInput, String attemptInput) {

        final int numberOfCars = parseInt(carInput);
        final int numberOfAttempts = parseInt(attemptInput);

        RacingGame racingGame = new RacingGame(numberOfCars);
        ConsoleView consoleView = new ConsoleView();

        for (int i = 0; i < numberOfAttempts; i++) {
            List<CarResponseDto> cars = getCarResponseDtos(racingGame);
            consoleView.print(cars);
        }
    }

    private List<CarResponseDto> getCarResponseDtos(RacingGame racingGame) {
        return racingGame.start()
                .stream()
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
