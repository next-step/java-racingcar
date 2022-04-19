package racingcar;

public class RacingCar implements Comparable {
    private final static int MOVE_THRESHOLD = 3;
    private final static int MOVE = 1;
    private final static int STAY = 0;

    private int movement;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public int move(int condition) {
        this.movement += condition > MOVE_THRESHOLD ? MOVE : STAY;
        return movement;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

    public String compareWithHighestScoreCar(RacingCar highestCar) {
        if (this.movement == highestCar.getMovement()) {
            return this.name;
        }
        return "";
    }

    @Override
    public int compareTo(Object o) {
        RacingCar another = (RacingCar) o;
        return Integer.compare(this.movement, another.getMovement()) * -1;
    }
}
