package racingGame.domain.participant;

import racingGame.domain.car.Car;

import java.util.Objects;

public class ParticipantScore {
    private String carName;
    private int position;

    public ParticipantScore(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantScore)) return false;
        ParticipantScore that = (ParticipantScore) o;
        return position == that.position &&
                Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
