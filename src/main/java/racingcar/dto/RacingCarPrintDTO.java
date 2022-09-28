package racingcar.dto;

import java.util.Objects;

import racingcar.domain.RacingCar;

public class RacingCarPrintDTO {

    private final String racingCarName;
    private final int position;

    public RacingCarPrintDTO(RacingCar racingCar) {
        this.racingCarName = racingCar.getName();
        this.position = racingCar.getPosition();
    }

    public String getRacingCarName() {
        return racingCarName;
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
