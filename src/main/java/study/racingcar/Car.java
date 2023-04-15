package study.racingcar;

public class Car {
    /**
     * 차량을 담당한다.
     */
    public static final String CAR_SHAPE = "-";
    public static final int MOVABLE_LOWER_BOUND = 4;
    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public static boolean isMovable(int randomValue) {
        return randomValue >= MOVABLE_LOWER_BOUND;
    }

    public void move() {
        position.increase();
    }

    @Override
    public String toString() {
        return CAR_SHAPE.repeat(position.getPosition());
    }
}