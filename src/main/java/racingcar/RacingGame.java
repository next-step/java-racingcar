package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.wrapper.PositiveNumber;
import racingcar.util.NumberCreator;
import racingcar.util.PrintUtil;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void play() {
        InputView inputView = new InputView(new Scanner(System.in));
        PositiveNumber carNumber = new PositiveNumber(inputView.carNumber());
        PositiveNumber movement = new PositiveNumber(inputView.movement());

        Cars cars = createCars(carNumber);
        StringBuilder result = new StringBuilder();
        for (int index = 0; movement.isGreaterThan(index); index++) {
            cars.moveAll(new RandomNumberGenerator());
            result.append(PrintUtil.result(cars));
        }

        ResultView resultView = new ResultView();
        resultView.print(result.toString());

    }

    private static Cars createCars(PositiveNumber carSize) {
        List<Car> carList = new ArrayList<>();
        for (int index = 0; carSize.isGreaterThan(index); index++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }
}
