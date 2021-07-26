package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Cars;
import edu.nextstep.racingcar.step3.error.CarError;
import edu.nextstep.racingcar.step3.util.RandomUtils;
import edu.nextstep.racingcar.step3.view.InputView;
import edu.nextstep.racingcar.step3.view.ResultView;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class App {

    private static final int NUMBER_OF_RANDOMS = 10;
    private static final int THRESHOLD = 4;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Cars cars = make(inputView.getNumberOfCars(), NUMBER_OF_RANDOMS, THRESHOLD);
        cars.play(inputView.getNumberOfAttempts());

        resultView.print(inputView.getNumberOfAttempts(), cars);
    }

    public static Cars make(int numberOfCars, int numberOfRandoms, int threshold) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(idx -> new Car(getValidator(numberOfRandoms, threshold),
                        getMoveStrategy(numberOfRandoms, threshold)))
                .collect(toCollection(Cars::new));
    }

    public static Car.MoveStrategy getMoveStrategy(int numberOfRandoms, int threshold) {
        return () -> {
            RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
            return randomUtils.getRandomNumber() >= threshold;
        };
    }

    public static Car.ParamsValidator getValidator(int numberOfRandoms, int threshold) {
        return () -> {
            if (numberOfRandoms <= threshold) {
                throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
            }
        };
    }
}
