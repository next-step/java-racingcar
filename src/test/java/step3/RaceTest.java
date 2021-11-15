package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.ArrayList;
import java.util.List;

class RaceTest {

    private Race race =  new Race();
    private RacingCarGroup racingCarGroup;

    @BeforeEach
    private void createCarGroup() {
        RacingManager racingManager = new RandomManager();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(racingManager));
        cars.add(new Car(racingManager));
        cars.add(new Car(racingManager));

        racingCarGroup = new RacingCarGroup(cars);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "2,2", "5,5", "6,6"})
    @DisplayName("경기 종료 후 기록 갯수는 경기 시도 횟수와 같다")
    public void test(int trial, int expected) {
        race.ready(racingCarGroup, new Count(trial));
        List<Record> recordList = race.start();

        Assertions.assertThat(recordList.size()).isEqualTo(expected);
    }
}