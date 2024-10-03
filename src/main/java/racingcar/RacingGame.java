package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.wrapper.CarName;
import racingcar.model.wrapper.MovementNumber;
import racingcar.util.PrintUtil;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    public static void play() {
        InputView inputView = new InputView(new Scanner(System.in));
        List<CarName> carNames = Arrays.stream(inputView.carNames().split(","))
                .map(CarName::new)
                .collect(Collectors.toList());
        MovementNumber movementNumber = new MovementNumber(inputView.movement());

        Cars cars = createCars(carNames);
        StringBuilder result = new StringBuilder();
        for (int index = 0; movementNumber.isGreaterThan(index); index++) {
            cars.moveAllByNumberCreator(new RandomNumberGenerator());
            result.append(PrintUtil.result(cars));
        }

        ResultView resultView = new ResultView();
        resultView.print(result.toString());

    }

    private static Cars createCars(List<CarName> carNames) {
        Car[] cars = carNames.stream()
                .map(Car::new)
                .toArray(Car[]::new);

        return Cars.newInstance(cars);
    }
}
