import racingCar.domain.Car;
import racingCar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static racingCar.view.InputView.getCarNames;
import static racingCar.view.InputView.getTrial;
import static racingCar.view.ResultView.printCars;
import static racingCar.view.ResultView.showWinner;


public class main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        String inputString = getCarNames();
        int trial = getTrial();

        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }

        RacingCar racingCar = new RacingCar(trial);
        while(!racingCar.isEnd()) {
            racingCar.run(cars);
            printCars(cars);
        }
        showWinner(cars);
    }
}
