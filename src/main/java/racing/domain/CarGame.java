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
        for (String name : names) {
            this.cars.add(Car.withName(name));
        }
        return cars;
    }

    public RoundRecords start() {
        List<RoundRecord> records = new ArrayList<>();

        for (int i = 0; i < rounds; i++) {
            RoundRecord record = playRound();
            records.add(record);
        }
        return new RoundRecords(records);
    }

    private RoundRecord playRound() {
        RoundRecord record = new RoundRecord();
        for (Car car : cars) {
            car.forward(moveStrategy);
            record.addHistory(car);
        }
        return record;
    }
}
