package racingcar;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    private static final int MAX_CAR_NAME_SIZE = 5;
    private String carName;
    private int distance;

    public RacingCar() { }

    public RacingCar(String carName) {
        if (invalidCarName(carName)) {
            carName = carName.substring(0, MAX_CAR_NAME_SIZE);
        }
        this.carName = carName;
    }

    public boolean isWinner(int longestDistance) {
        return this.distance == longestDistance;
    }

    private boolean invalidCarName(String carName) {
        return carName.length() > MAX_CAR_NAME_SIZE;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int isLongestDistance(int longestDistance) {
        return Math.max(longestDistance, this.distance);
    }
}
