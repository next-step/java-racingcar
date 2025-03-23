package study.CarRacing;

import java.util.List;
import java.util.Random;

public class CarRacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfRounds = inputView.getNumberOfRounds();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Race race = new Race(numberOfCars, movingStrategy);
        ResultView resultView = new ResultView();
        Random random = new Random();

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            race.playRound(random);
            List<Car> cars = race.getCars();
            resultView.printResult(cars);
            resultView.printRoundSeparator();
        }
    }
}
