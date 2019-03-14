package racing;

import java.util.List;

public class RacingGameMain {
    public static void main(String args[]) {

        int numberOfCars = InputView.getNumberOfCar();
        int timeToTry = InputView.getTimeToTry();

        List<Car> cars = new RacingGame(numberOfCars).getCars();

        int time = 0;
        while(time < timeToTry) {
            cars = RacingGame.race(cars);
            ResultView.printResult(cars);
            time++;
        }

    }
}
