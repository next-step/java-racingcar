package step3and4.game;

import step3and4.client.input.InputView;
import step3and4.client.number.Number;
import step3and4.client.output.OutputView;
import step3and4.game.car.Cars;

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
        final int numberOfCars = inputView.answerToQuestion("자동차 대수는 몇 대 인가요?");
        Cars cars = cars(numberOfCars);

        final int numberOfGames = inputView.answerToQuestion("시도할 회수는 몇 회 인가요?");
        useTurns(cars, numberOfGames);
    }

    private Cars cars(int numberOfCars) {
        final Cars.Factory carsFactory = new Cars.Factory(numberOfCars);
        return carsFactory.cars(number, outputView);
    }

    private void useTurns(Cars cars, int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            cars = cars.carsWithTurnUsed();
            cars.printPosition();
            System.out.println();
        }
    }

}
