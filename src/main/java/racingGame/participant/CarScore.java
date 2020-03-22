package racingGame.participant;

import racingGame.car.Car;

public class CarScore {
    private String carName;
    private int position;

    public CarScore(Car car) {
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
