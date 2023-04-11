package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RacingTest {

    @DisplayName("요청된 양만큼 Car 생성 확인")
    @Test
    void car() {
        Racing racing = new Racing(3, 3);
        List<Car> cars = racing.getCars();
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("요청된 게임수만큼 게임기록 생성 확인")
    @Test
    void 게임기록_저장() {
        Racing racing = new Racing(3, 5);
        racing.race();
        List<List<Integer>> raceRecord = racing.getRaceRecord();
        Assertions.assertThat(raceRecord.size()).isEqualTo(5);
    }



}
