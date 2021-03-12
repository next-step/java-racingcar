package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Cars;

class RacingEventTest {

    @DisplayName("자동차 경주 자동차 대수 확인 & 시도 횟수 확인")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5","pobi,crong,honux:7"}, delimiter = ':')
    void racingEventTest(String carNames, int tryCount){
        RacingEvent racingEvent = new RacingEvent(new Cars(carNames.split(",")),tryCount);
        assertThat(racingEvent.getCars().size()).isEqualTo(carNames.split(",").length);
        assertThat(racingEvent.getCount()).isEqualTo(tryCount);
    }

    @DisplayName("레이싱 실행 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5","pobi,crong,honux:7"}, delimiter = ':')
    void StartRacingEventTest(String carNames, int tryCount){
        RacingEvent racingEvent = new RacingEvent(new Cars(carNames.split(",")),tryCount);
        racingEvent.start();
    }

}
