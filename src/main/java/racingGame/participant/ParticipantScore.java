package racingGame.participant;

import racingGame.car.Car;

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
}
