package racing.model;

import java.util.List;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int INIT_POSITION = 1;

    private final CarName name;
    private final int position;

    public Car(String title) {
        this.name = new CarName(title);
        this.position = INIT_POSITION;
    }

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MOVE_CONDITION) {
            return new Car(this.name, this.position + 1);
        }
        return this;
    }

    public CarName getName() {
        return name;
    }


    public int getPosition() {
        return position;
    }

    public int max(int other) {
        return Math.max(this.position, other);
    }

    public List<Car> addWinner(int maxPosition, List<Car> winners) {
        if (this.position == maxPosition) {
            winners.add(this);
        }
        return winners;
    }
}
