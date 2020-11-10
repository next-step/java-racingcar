package racingcar;

import racingcar.application.RacingSimulator;
import racingcar.domain.Car;
import racingcar.application.CarsGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class MainSimulator {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarsGenerator carsGenerator = new CarsGenerator();
        RacingSimulator racingSimulator = new RacingSimulator();

        String nameOfCars = inputView.insertNameOfCars();
        int countOfRacing = inputView.insertCount();

        List<Car> cars = carsGenerator.generateCars(nameOfCars);

//        racingSimulator.race(cars, countOfRacing);
//TODO 경주결과 한번에 뽑기
        for (int i = 0; i < countOfRacing; i++) {
            racingSimulator.moveCars(cars);
            resultView.printDistanceOfCar(cars);
        }

    }
}
