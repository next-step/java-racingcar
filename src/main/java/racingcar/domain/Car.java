package racingcar.domain;

public class Car {
    private Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int greaterThan(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
}
