package controller;

import domain.Car;
import domain.Name;
import domain.RacingGame;
import domain.RandomMoveStrategy;
import view.InputView;
import view.ConsoleResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RacingGameController {

    private static final String CAR_NAMES_FORMAT_REGEX = "^[a-zA-Z]+(,[a-zA-Z]+)*$";

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.play();
    }

    public void play() {
        String carNames = InputView.promptForCarNames();
        if (!isValidFormat(carNames)) {
            throw new IllegalArgumentException("올바른 포맷이 아닙니다.");
        }
        int moveCount = InputView.promptForMoveCount();
        assertionPositiveNumber(moveCount);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(new Name(name), new RandomMoveStrategy()));
        }
        RacingGame racingGame = new RacingGame(cars, moveCount);
        racingGame.play(new ConsoleResultView());

        ConsoleResultView.printWinner(racingGame.winner());
    }

    private boolean isValidFormat(String carNames) {
        return Pattern.matches(CAR_NAMES_FORMAT_REGEX, carNames);
    }

    private void assertionPositiveNumber(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("1 이상의 양수만 입력할 수 있습니다.");
        }
    }
}
