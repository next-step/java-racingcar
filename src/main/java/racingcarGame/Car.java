package racingcarGame;

import java.util.Objects;

import static racingcarGame.client.MessageClient.show;

public class Car {
    private static final String POSITION_SHOW_MARK = "-";

    private int position;
    private String movement;

    public Car(int position, String movement) {
        this.position = position;
        this.movement = movement;
    }

    public Car move() {
        this.position += 1;
        this.movement += POSITION_SHOW_MARK;

        return new Car(position, movement);
    }

    public void showMovement() {
        show(this.movement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(movement, car.movement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, movement);
    }
}
