package racingcargame;

public class RacingCar implements Comparable<RacingCar> {
    private static final int MOVING_VALUE = 4;
    private int distance = 0;
    private int rank = 0;
    private String carName = "";

    RacingCar (String carName) {
        this.carName = carName;
    }

    public int tryToMove(int randomValue) {
        if (randomValue >= MOVING_VALUE) {
            return this.move();
        }
        return this.stop();
    }

    private int move() {
        return distance += 1;
    }

    private int stop() {
        return distance += 0;
    }

    public int getDistance() {
        return distance;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        if (racingCar.distance < distance) {
            return 1;
        } else if (racingCar.distance > distance) {
            return -1;
        }
        return 0;
    }
}