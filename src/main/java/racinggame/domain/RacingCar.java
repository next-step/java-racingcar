package racinggame.domain;

public class RacingCar {

    private String carName;
    private int carPosition = 0;

    private RacingCar() {}

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.carPosition;
    }

    public void forward() {
        this.carPosition += 1;
    }
}
