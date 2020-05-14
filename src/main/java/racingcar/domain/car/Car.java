package racingcar.domain.car;

public class Car {
    private int location;

    public int move(Power power) {
        if (power.isMovable()) {
            location++;
        }

        return location;
    }
}
