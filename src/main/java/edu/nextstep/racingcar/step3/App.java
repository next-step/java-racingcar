package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Vehicle;
import edu.nextstep.racingcar.step3.error.CarError;
import edu.nextstep.racingcar.step3.util.RandomUtils;
import edu.nextstep.racingcar.step3.view.InputView;
import edu.nextstep.racingcar.step3.view.ResultView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    private static final int NUMBER_OF_RANDOMS = 10;
    private static final int THRESHOLD = 4;
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        resultView.play(inputView.getNumberOfAttempts(), make(inputView.getNumberOfCars(), NUMBER_OF_RANDOMS, THRESHOLD));
    }

    public static List<Vehicle> make(int numberOfCars, int numberOfRandoms, int threshold) {

        Car.ParamsValidator validator = () -> {
            if (numberOfRandoms <= threshold) {
                throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
            }
        };

        Supplier<Boolean> movement = () -> {
            RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
            return randomUtils.getRandomNumber() >= threshold;
        };

        return IntStream.range(0, numberOfCars)
                .mapToObj(idx -> new Car(validator, movement))
                .collect(Collectors.toList());
    }
}
