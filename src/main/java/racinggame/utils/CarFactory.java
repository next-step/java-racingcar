package racinggame.utils;

import racinggame.domain.Car;
import racinggame.domain.value.Name;
import racinggame.domain.value.Position;
import racinggame.vo.InputValue;
import racinggame.service.RacingCars;
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
                .map(name -> new Car(Name.of(name), Position.createInitPosition()))
                .collect(Collectors.toList());
    }
}
