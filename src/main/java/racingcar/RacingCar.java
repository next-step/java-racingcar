package racingcar;

public class RacingCar {

    private int distance;
    private RandomNumberGenerator randomNumberGenerator;

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    public RacingCar() { }

    public RacingCar(int distance, RandomNumberGenerator randomNumberGenerator) {
        this.distance = distance;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance++;
        }
    }

    public void moveOrStop() {
        if (isMovable()) {
            distance++;
        }
    }

    private boolean isMovable() {
        return randomNumberGenerator.generateRacingRandomNumber() >= MOVABLE_BOUNDARY_NUMBER;
    }

}
