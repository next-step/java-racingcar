package edu.nextstep.racingcar.step4;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step4.domain.Car;
import edu.nextstep.racingcar.step4.domain.Cars;
import edu.nextstep.racingcar.step4.error.CarError;
import edu.nextstep.racingcar.step4.util.RandomUtils;
import edu.nextstep.racingcar.step4.view.InputView;
import edu.nextstep.racingcar.step4.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class App {

    private static final int NUMBER_OF_RANDOMS = 10;
    private static final int THRESHOLD = 4;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Cars cars = make(inputView.getInputInfo().getNamesOfCars(), NUMBER_OF_RANDOMS, THRESHOLD);
        cars.play(inputView.getInputInfo().getNumberOfAttempts());

        resultView.output(inputView.getInputInfo().getNumberOfAttempts(), cars);
        resultView.outputWinners(cars.getWinners());
    }

    public static Cars make(String namesOfCars, int numberOfRandoms, int threshold) {
        return Arrays.stream(namesOfCars.split(","))
                .map(name -> new Car(name,getValidator(name,numberOfRandoms, threshold),
                        getMoveStrategy(numberOfRandoms, threshold)))
                .collect(toCollection(Cars::new));
    }

    public static Car.MoveStrategy getMoveStrategy(int numberOfRandoms, int threshold) {
        return () -> {
            RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
            return randomUtils.getRandomNumber() >= threshold;
        };
    }

    public static Car.ParamsValidator getValidator(String name, int numberOfRandoms, int threshold) {
        return () -> {
            if (numberOfRandoms <= threshold) {
                throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
            }

            if (name.length() > 5) {
                throw new BusinessException(CarError.INVALID_VALUE_TOO_LONG_CAR_NAME);
            }
        };
    }
}
