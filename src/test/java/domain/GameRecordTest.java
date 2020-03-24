package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameRecordTest {

    private GameRecord gameRecord;
    private List<Car> cars;

    @BeforeEach
    public void setup() {
        cars = new ArrayList<>();
        cars.add(new Car("myCar1"));
        cars.add(new Car("myCar2"));
        cars.add(new Car("myCar3"));
        gameRecord = new GameRecord(cars);
    }
}
