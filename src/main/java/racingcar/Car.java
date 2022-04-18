package racingcar;


import java.util.Objects;

public class Car {
    private static final int MIN_NUMBER_BE_MOVES = 4;
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(Position position) {
        this.position = position;
    }

    private void move() {
        this.position = this.position.move();
    }

    private boolean canBeMove(int value) {
        return (value >= MIN_NUMBER_BE_MOVES);
    }

    public void play(int number) {
        if(canBeMove(number)) {
            move();
        }
    }

    public int getDistance() {
        return this.position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
