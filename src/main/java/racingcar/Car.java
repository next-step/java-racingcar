package racingcar;

public class Car {
    private MoveStrategy moveStrategy = new FourOverTenMoveStrategy();
    private String name;
    private int position = 0;

    public Car(MoveStrategy moveStrategy, String name) {
        validateName(name);
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void tryMove() {
        move(moveStrategy.isMovable());
    }

    private void move(boolean isMovable) {
        if (isMovable) {
            increasePosition();
        }
    }

    private void increasePosition() {
        this.position += 1;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Length of the car name has exceeded 5.");
        }
    }
}
