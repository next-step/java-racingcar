package racingcar;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    private static final int MAX_CAR_NAME_SIZE = 5;
    private String carName;
    private Distance distance;

    public RacingCar() { }

    public RacingCar(String carName) {
        this(carName, new Distance());
    }

    public RacingCar(String carName, Distance distance) {
        if (invalidCarName(carName)) {
            this.carName = carName.substring(0, MAX_CAR_NAME_SIZE);
        }
        this.distance = distance;
    }

    public boolean isWinner(int longestDistance) {
        return distance.isLongestDistance(longestDistance);
    }

    private boolean invalidCarName(String carName) {
        return carName.length() > MAX_CAR_NAME_SIZE;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance.goStraight();
        }
    }

    public String getCarName() {
        return carName;
    }

    public int findLongestDistance(int longestDistance) {
        return distance.findLongestDistance(longestDistance);
    }

    public String myDistanceToString() {
        return distance.distanceToString();
    }
}
