package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_NUM = 4;
    private static final int WINNER_POSITION = 5;
    private CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
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
        return this.name.getName();
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
        if (this.position >= WINNER_POSITION) {
            return true;
        }
        return false;
    }
}
