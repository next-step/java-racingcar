package step3and4and5.game;

import step3and4and5.client.input.InputView;
import step3and4and5.client.output.OutputView;
import step3and4and5.game.car.Cars;
import step3and4and5.game.car.Number;
import step3and4and5.game.car.WinningCars;

import java.io.IOException;

public class CarGame {

    private final Number number;

    private final InputView inputView;

    private final OutputView outputView;

    public CarGame(Number number, InputView inputView, OutputView outputView) {
        this.number = number;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {
        final String[] carsNames = inputView.carsNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Cars cars = cars(carsNames);

        final int numberOfGames = inputView.answerToQuestion("시도할 회수는 몇 회 인가요?");

        outputView.print(new WinningCars(lastUseTurnsCars(cars, numberOfGames)));
    }

    private Cars cars(String[] carsNames) {
        final Cars.Factory carsFactory = new Cars.Factory(carsNames);
        return carsFactory.cars(number);
    }

    private Cars lastUseTurnsCars(Cars cars, int numberOfGames) {
        verifyPositiveNumber(numberOfGames);

        for (int i = 0; i < numberOfGames; i++) {
            cars = cars.carsWithTurnUsed();
            outputView.print(cars);
        }
        return cars;
    }

    private void verifyPositiveNumber(int numberOfGames) {
        if (numberOfGames <= 0) {
            throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다.");
        }
    }

}
