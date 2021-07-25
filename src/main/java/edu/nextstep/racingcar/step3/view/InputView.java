package edu.nextstep.racingcar.step3.view;

import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Vehicle;
import edu.nextstep.racingcar.step3.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private final Integer numberOfCars;

    public InputView(Integer numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Vehicle> make(Integer numberOfRandoms, Integer threshold) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(idx -> new Car(threshold, new RandomUtils(numberOfRandoms)))
                .collect(Collectors.toList());
    }
}
