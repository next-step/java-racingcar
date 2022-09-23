package racinggame;

import racinggame.dto.RaceConfigurationDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {
    private CarFactory() {
    }

    public static List<Car> produce(RaceConfigurationDTO dto) {
        return IntStream.range(0, dto.carCount())
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

}
