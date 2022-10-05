package racinggame.domain;

import racinggame.domain.embeded.CarDistance;
import racinggame.dto.RaceInputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static final int DEFAULT_CAR_DISTANCE = 0;

    private CarFactory() {
    }

    public static RacingCars produce(RaceInputDTO dto) {
        List<Car> cars = Arrays.stream(dto.getCarNames())
                .map(name -> new Car(name, new CarDistance(DEFAULT_CAR_DISTANCE)))
                .collect(Collectors.toList());

        return new RacingCars(cars);
    }

}
