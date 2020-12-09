package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private CarMover carMover;

    public Cars(int carCount) {
        this.carMover = new CarMover();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public void play() {
        cars.forEach(car -> carMover.moveOrNot(car, NumberUtil.generateRandomIntZeroToTen()));
    }

    public String getWayResult() {
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(car -> {
            stringBuilder.append(car.getWayResult());
            stringBuilder.append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}
