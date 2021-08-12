package racingcargame;

public class RacingCar implements Comparable<RacingCar> {
    private static final int MOVING_VALUE = 4;
    private static final int FIRST_DISTANCE = 0;
    private final RacingCarName carName;
    private Distance distance;

    RacingCar (RacingCarName carName) {
        this(carName, new Distance(FIRST_DISTANCE));
    }

    RacingCar (RacingCarName carName, Distance distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public int tryToMove(int randomValue) {
        if (randomValue >= MOVING_VALUE) {
            return this.move();
        }
        return this.stop();
    }

    private int move() {
        return distance.increase();
    }

    private int stop() {
        return distance.getValue();
    }

    public int showDistance() {
        return distance.getValue();
    }

    public String showCarName() {
        return carName.getName();
    }

    public boolean isWinner(int winnerDistance) {
        return distance.getValue() == winnerDistance;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
       return Integer.compare(distance.getValue(), racingCar.showDistance());
    }
}