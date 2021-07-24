package racingcar;

import java.util.Objects;

public class Car {
    private final int MOVE_NUM = 4;
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new RuntimeException();
        }
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new RuntimeException();
        }
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if(isMove(randomNumber)){
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isWinner() {
        final int WINNER_POSITION = 5;
        if (this.position == WINNER_POSITION) {
            return true;
        }
        return false;
    }
}
