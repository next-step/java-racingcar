package racinggame.domain;

import racinggame.dto.RaceInputDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {
    private CarFactory() {
    }

    public static List<Car> produce(RaceInputDTO dto) {
        return IntStream.range(0, dto.carCount())
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

}
