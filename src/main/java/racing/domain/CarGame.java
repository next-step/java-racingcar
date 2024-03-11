package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final List<Car> cars;
    private final int rounds;
    private final MoveStrategy moveStrategy;

    public CarGame(int carCount, int rounds, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();
        createCar(carCount);
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    private List<Car> createCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        return cars;
    }

    public List<RoundRecord> start() {
        List<RoundRecord> records = new ArrayList<>();

        for (int i = 0; i < rounds; i++) {
            RoundRecord record = new RoundRecord();
            for (Car car : cars) {
                record.add(car.forward(moveStrategy));
            }
            records.add(record);
        }
        return records;
    }
}
