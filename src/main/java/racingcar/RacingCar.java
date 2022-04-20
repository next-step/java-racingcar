package racingcar;

import java.util.Objects;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    private static final int MAX_CAR_NAME_SIZE = 5;
    private String carName;
    private Distance distance;

    public RacingCar() {
        this("", new Distance());
    }

    public RacingCar(String carName) {
        this(carName, new Distance());
    }

    public RacingCar(int distance) {
        this("", new Distance(distance));
    }

    public RacingCar(String carName, Distance distance) {
        if (invalidCarName(carName)) {
            carName = carName.substring(0, MAX_CAR_NAME_SIZE);
        }
        this.carName = carName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(carName, racingCar.carName) && Objects.equals(distance, racingCar.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }
}
