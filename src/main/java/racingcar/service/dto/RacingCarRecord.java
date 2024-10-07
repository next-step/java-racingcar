package racingcar.service.dto;

import racingcar.domain.RacingCar;

import java.util.Objects;

public class RacingCarRecord {
    private final String name;
    private final int position;

    public RacingCarRecord(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static RacingCarRecord from(RacingCar racingCar) {
        return new RacingCarRecord(racingCar.getName(), racingCar.getPosition());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        RacingCarRecord that = (RacingCarRecord) object;
        return getPosition() == that.getPosition() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
