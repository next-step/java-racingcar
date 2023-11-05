package step3.racingcar;

public class RacingCar {
    private int distanceTraveled;

    private RacingCar() {
    }

    public static RacingCar build() {
        return new RacingCar();
    }

    public int currentDistance() {
        return distanceTraveled;
    }
}
