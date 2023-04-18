package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("요청된 양만큼 Car 생성 확인")
    @Test
    void car() {
        Racing racing = new Racing(createCarNames(), 3);
        List<Car> cars = racing.getCars();
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("요청된 게임수만큼 게임기록 생성 확인")
    @Test
    void 게임기록_저장() {
        Racing racing = new Racing(createCarNames(), 5);
        racing.race();
        List<RaceRecord> raceRecord = racing.getRaceRecord();
        assertThat(raceRecord.size()).isEqualTo(5);
    }

    @DisplayName("우승자 체크")
    @Test
    void 우승자_1명_이상() {
        Racing racing = new Racing(createCarNames(), 5);
        List<Car> winner = racing.getWinner();
        assertThat(winner.size() > 1).isTrue();
    }

    private List<String> createCarNames() {
        List<String> carsNames = new ArrayList<>();
        carsNames.add("car1");
        carsNames.add("car2");
        carsNames.add("car3");
        return carsNames;
    }



}
