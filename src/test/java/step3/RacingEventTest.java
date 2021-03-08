package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingEventTest {

    @DisplayName("자동차 경주 자동차 대수 확인 & 시도 횟수 확인")
    @ParameterizedTest
    @CsvSource({"3,5","5,7"})
    void racingEventTest(int carCount, int tryCount){
        RacingEvent racingEvent = new RacingEvent(carCount,tryCount);
        assertThat(racingEvent.cars.size()).isEqualTo(carCount);
        assertThat(racingEvent.count).isEqualTo(tryCount);

    }

}
