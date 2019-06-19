package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        String inputCarNumber = InputView.inputCarNames();
        int inputExecuteNumber = InputView.inputExecuteNumber();

        List<Car> cars = null;
        RacingGame racingGame = new RacingGame(createCars(inputCarNumber));
        while (inputExecuteNumber > 0) {
            cars = racingGame.move();
            OutputView.racingResult(cars);
            inputExecuteNumber--;
        }
        OutputView.racingWinnerResult(cars);
    }

    private static List<Car> createCars(String inputCarNames){
        String[] carNames = inputCarNames.split(",");
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

}
