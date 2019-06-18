package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        int inputCarNumber = InputView.inputCarNumber();
        int inputExecuteNumber = InputView.inputExecuteNumber();

        RacingGame racingGame = new RacingGame(createCars(inputCarNumber));
        while (inputExecuteNumber > 0) {
            List<Car> cars = racingGame.move();
            OutputView.racingResult(cars);
            inputExecuteNumber--;
        }
    }

    private static List<Car> createCars(int inputCarNumber){
        List<Car> cars = new ArrayList<>();
        while (inputCarNumber > 0) {
            cars.add(new Car());
            inputCarNumber--;
        }
        return cars;
    }

}
