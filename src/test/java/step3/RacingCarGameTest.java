package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 4", "5, 6"})
    @DisplayName("자동차 게임에 참여하는 자동차와 시도가 정상적으로 객체 생성 되었는지 확인합니다")
    void ready(int carCount, int attemptCount) {
        RacingCarGame racingCarGame = new RacingCarGame();
        boolean result = racingCarGame.ready(carCount, attemptCount);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : 2"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차와 시도가 정상적으로 객체 생성 되었는지 확인합니다")
    void ready(String allRacingCarName, int attemptCount) {
        RacingCarGame racingCarGame = new RacingCarGame();
        boolean result = racingCarGame.ready(allRacingCarName, attemptCount);
        assertThat(result).isTrue();
    }

}