package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getTrial;
import static racingcar.view.ResultView.printCars;
import static racingcar.view.ResultView.showWinner;


public class RacingCarApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        String inputString = getCarNames();
        int trial = getTrial();

        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }

        RacingCar racingCar = new RacingCar(cars, trial);
        while (!racingCar.isEnd()) {
            racingCar.run();
            printCars(cars);
        }
        List<Car> winners = racingCar.getWinner();
        showWinner(winners);
    }
}
