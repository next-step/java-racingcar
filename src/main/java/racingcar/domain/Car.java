package racingcar.domain;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position = new Position(this.position.getPosition() + 1);
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int greaterThan(int maxPosition) {
        return this.position.greaterThan(maxPosition);

    }
}
