package step3.domain.history;

import step3.domain.Car;

public class CarHistory {
    private String name;
    private int position;

    private CarHistory() {}

    public CarHistory(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
