package racinggame.utils;

import racinggame.Car;
import racinggame.vo.InputValue;
import racinggame.RacingCars;
import racinggame.exception.NotInstanceException;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
        throw new NotInstanceException();
    }

    public static RacingCars createRacingCars(InputValue inputValue) {
        return new RacingCars(createCars(inputValue));
    }

    private static List<Car> createCars(InputValue inputValue) {
        return inputValue.carNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }


}
