package racinggame.domain.embeded;

import racinggame.domain.Car;
import racinggame.domain.RacingCars;
import racinggame.dto.RaceInputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private CarFactory() {
    }

    public static RacingCars produce(RaceInputDTO dto) {
        List<Car> cars = Arrays.stream(dto.getCarNames())
                .map(Car::new)
                .collect(Collectors.toList());

        return new RacingCars(cars);
    }

}
