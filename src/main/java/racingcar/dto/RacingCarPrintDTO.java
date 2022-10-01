package racingcar.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarPrintDTO {

    private final String name;
    private final int position;

    public RacingCarPrintDTO(RacingCar racingCar) {
        this.name = racingCar.getName();
        this.position = racingCar.getPosition();
    }

    public static List<RacingCarPrintDTO> from(RacingCars racingCars) {
        return racingCars.getValue()
            .stream()
            .map(RacingCarPrintDTO::new)
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCarPrintDTO)) {
            return false;
        }

        RacingCarPrintDTO that = (RacingCarPrintDTO) o;

        if (position != that.position) {
            return false;
        }
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
