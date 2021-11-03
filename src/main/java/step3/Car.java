package step3;

public class Car {
    private final static int MOVE_CONDITION = 4;
    private final static Long BASE_POSITION = 0L;
    private Position position;

    public Car() {
        this.position = Position.create(BASE_POSITION);
    }

    public Position getPosition() {
        return position;
    }

    public void moveOrStop(int rand) {
        if (isGo(rand)) {
            move();
        }
    }

    private void move() {
        this.position = this.position.move();
    }

    private boolean isGo(int rand) {
        return rand >= MOVE_CONDITION;
    }
}
