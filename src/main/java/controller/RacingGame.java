package controller;

import domain.Car;
import domain.Cars;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final int numberOfRounds;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public RacingGame(String[] nameOfCars, int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        this.cars = new Cars(nameOfCars);
    }

    public static void main(String[] args) {
        String[] nameOfCars = InputView.getNameOfCars();
        int numberOfRounds = InputView.getNumberOfRounds();

        RacingGame game = new RacingGame(nameOfCars, numberOfRounds);
        game.run();
    }

    private void runOneRound() {
        for (Car car : cars.getCars()) {
            car.move(randomNumberGenerator);
            ResultView.printPosition(car.getName(), car.getCurrentPosition());
        }
        ResultView.printMessage("");
    }

    private void run() {
        ResultView.printMessage("실행 결과");
        for (int i = 0; i < this.numberOfRounds; i++) {
            runOneRound();
        }
        ResultView.printWinner(cars.getWinners());
    }

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfRounds = InputView.getNumberOfRounds();

        RacingGame game = new RacingGame(numberOfCars, numberOfRounds);
        game.run();
    }
}
