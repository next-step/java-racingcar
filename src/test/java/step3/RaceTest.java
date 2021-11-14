package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RaceTest {

    private Race race =  new Race();

    @ParameterizedTest
    @CsvSource(value = {"3,3,3", "4,2,2", "3,5,5", "2,6,6"})
    @DisplayName("경기 종료 후 기록 갯수는 경기 시도 횟수와 같다")
    public void test(int car, int trial, int expected) {
        race.ready(new Count(car), new Count(trial));
        List<Record> recordList = race.start();

        Assertions.assertThat(recordList.size()).isEqualTo(expected);
    }
}