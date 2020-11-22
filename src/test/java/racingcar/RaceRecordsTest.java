package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RaceRecords;

import java.util.ArrayList;
import java.util.List;

public class RaceRecordsTest {

    @Test
    public void save_records() {
        RaceRecords raceRecords = new RaceRecords();
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        carName.add("car3");
        Cars cars = new Cars(carName);

        raceRecords.saveRecords(cars, 3);
    }
}
