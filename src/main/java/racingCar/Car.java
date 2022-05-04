package racingCar;

import java.util.Objects;

public class Car {
    public static final int MOVE_CRITERIA = 4;

    private Name name;
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public int currentPosition() {
        return this.position.getPosition();
    }

    public String makeNameAndPosition() {
        return this.name + " : " + makePosition();
    }

    public String makePosition() {
        return this.position.makePosition();
    }

    public void move(int randomNumber) {
        if (!new RandomNumber().validateRandomNumber(randomNumber)) {
            throw new IllegalStateException("randomNumber의 유효범위는 0~9입니다.");
        }

        if (canMovePosition(randomNumber)) {
            this.position.increase();
        }
    }

    public boolean canMovePosition(int randomNumber) {
        return (randomNumber >= MOVE_CRITERIA);
    }

    public Boolean checkPosition(int position) {
        return this.position.checkPosition(position);

    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.getPosition() == maxPosition;
    }

    public int maxPosition(int maxPosition) {
        if (maxPosition < this.position.getPosition()) {
            return this.currentPosition();
        }
        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name + ", ";
    }


}
