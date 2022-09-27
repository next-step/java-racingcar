package racinggame.domain;

import racinggame.dto.RaceInputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private CarFactory() {
    }

    public static List<Car> produce(RaceInputDTO dto) {
        return Arrays.stream(dto.getCarNames())
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

}
