package domain;

public class RacingCar {
    private static final int STANDARD_MOVE_COUNT = 4;
    private int position;
    private String name;

    public RacingCar() {
        this.position = 0;
    }

    public RacingCar(String name) {
        this.position = 0;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public static int getStandardMoveCount() {
        return STANDARD_MOVE_COUNT;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }
}
