package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Scanner;

public class RacingCarGame {
    public static final String MESSAGE_NEGATIVE_NUMBER_INPUT = "음수는 입력할 수 없습니다. input: %d";
    private Cars cars;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        InputView.printCarsNamesInputMessage();
        String names = inputNames(scanner);
        cars = CarFactory.create(names);

        InputView.printTryCountInputMessage();
        int tryCount = inputCount(scanner);

        play(tryCount);

        end();
    }

    private void end() {
        Car maxPositionCar = cars.findMaxPositionCar();
        Cars winners = cars.findWinners(maxPositionCar);

        ResultView.printResultHeader();
        ResultView.printCarsResult(cars);
        ResultView.printWinners(winners);
    }

    private String inputNames(Scanner scanner) {
        return scanner.nextLine();
    }

    public int inputCount(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        if (count < 0) {
            throw new IllegalArgumentException(String.format(MESSAGE_NEGATIVE_NUMBER_INPUT, count));
        }
        return count;
    }

    private void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
        }
    }
}
