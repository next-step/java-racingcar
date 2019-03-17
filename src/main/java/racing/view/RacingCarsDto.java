package racing.view;

import racing.application.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarsDto {
    private List<RacingCarDto> dtos;

    public RacingCarsDto(List<RacingCarDto> dtos) {
        this.dtos = dtos;
    }

    public static RacingCarsDto toRacingCarsDto(List<Car> dtos) {
        return new RacingCarsDto(dtos.stream()
                .map(v -> toRacingCarDto(v))
                .collect(Collectors.toList()));
    }

    private static RacingCarDto toRacingCarDto(Car car) {
        return new RacingCarDto(car.getName(), car.getPosition());
    }

    public Stream<RacingCarDto> stream() {
        return dtos.stream();
    }

    public List<RacingCarDto> getDtos() {
        return dtos;
    }
}