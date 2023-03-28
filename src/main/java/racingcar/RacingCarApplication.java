package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
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

        RacingCar racingCar = new RacingCar(new Cars(cars), trial);
        while (!racingCar.isEnd()) {
            racingCar.run();
            printCars(racingCar.getCars());
        }
        Cars winners = racingCar.getWinner();
        showWinner(winners);
    }
}
