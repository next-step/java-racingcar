package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceConditionTest {

    @DisplayName("참가자 수와 1회 이동을 시도한 결과의 수가 같은가")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,0})
    void attempt(Integer participationCount) {
        RaceCondition raceCondition = new RaceCondition(participationCount);
        assertThat(raceCondition.attempt().size()).isEqualTo(participationCount);
    }

    @DisplayName("참가자 수와 raceCondition 객체 안의 차량 수가 같은가")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,0})
    void getCarsCount(Integer participationCount) {
        RaceCondition raceCondition = new RaceCondition(participationCount);
        assertThat(raceCondition.getCarsCount()).isEqualTo(participationCount);

    }

}