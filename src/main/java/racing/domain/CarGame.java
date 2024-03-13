package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final List<Car> cars;
    private final int rounds;
    private final MoveStrategy moveStrategy;

    public CarGame(int rounds, MoveStrategy moveStrategy, String[] names) {
        this.cars = new ArrayList<>();
        createCar(names);
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    private List<Car> createCar(String[] names) {
        for (int i = 0; i < names.length; i++) {
            this.cars.add(new Car(names[i]));
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
