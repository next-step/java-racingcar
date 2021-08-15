package racing_refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing_refactoring.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @DisplayName("주어진 자동차 이름과 경주 횟수로 Racing 객체 생성")
    @CsvSource(value = {"'pobi,crong,honux',1", "'test,test2',3"})
    void setRacingValue(String carNames, int round) {
        Racing racing = new Racing(carNames, round);
        assertThat(racing).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("주어진 횟수 동안 경주 테스트")
    @ValueSource(ints = {4,5,6})
    void race(int round) {
        String carNames = "pobi,crong,honux";
        Racing racing = new Racing(carNames, round);

        for (int trial = 0; trial < round; trial++) {
            racing.race(() -> true);
        }

        assertThat(racing.roundFinish()).isTrue();
    }
}