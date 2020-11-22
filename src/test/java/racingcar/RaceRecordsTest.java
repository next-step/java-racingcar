package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RaceRecord;
import racingcar.domain.RaceRecords;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceRecordsTest {

    @Test
    @DisplayName("round에 해당하는 RaceRecord가 저장되는지 확인")
    public void save_records() {
        RaceRecords raceRecords = new RaceRecords();
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        carName.add("car3");
        Cars cars = new Cars(carName);

        RaceRecord raceRecord = raceRecords.saveRecords(cars, 3);
        assertThat(raceRecord.getRound()).isEqualTo(3);
    }
}
