package racingcar.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;

public class RacingCarPrintDTO {

    private final RacingCarName racingCarName;
    private final int position;

    public RacingCarPrintDTO(RacingCar racingCar) {
        this.racingCarName = new RacingCarName(racingCar.getName());
        this.position = racingCar.getPosition();
    }

    public static List<RacingCarPrintDTO> fromRacingCars(RacingCars racingCars) {
        return racingCars.getValue().stream()
            .map(RacingCarPrintDTO::new)
            .collect(Collectors.toList());
    }

    public String getRacingCarName() {
        return racingCarName.getValue();
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
        return Objects.equals(racingCarName, that.racingCarName);
    }

    @Override
    public int hashCode() {
        int result = racingCarName != null ? racingCarName.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
