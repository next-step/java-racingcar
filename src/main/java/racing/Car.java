package racing;

public class Car {
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void move(RacingGameManagement racingGameManagement) {
        racingGameManagement.addDrivingStatus(this, CarDrivingType.from(RandomMoveNumber.generate()));
    }
}
