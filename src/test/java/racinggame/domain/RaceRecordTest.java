package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceRecordTest {

    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {
        cars.add(new Car(new Position(1),"one"));
        cars.add(new Car(new Position(2),"two"));
        cars.add(new Car(new Position(3),"three"));
        cars.add(new Car(new Position(4),"winner1"));
        cars.add(new Car(new Position(4),"winner2"));

    }

    @Test
    void getWinners() {
        RaceRecord givenRecord = new RaceRecord(cars);

        List<Car> result = givenRecord.getWinners();

        assertThat(result).contains(cars.get(4), cars.get(3));
    }
}
