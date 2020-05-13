package racinggame.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingGameInfoTest {

    @DisplayName("숫자가 아닌 자동차대수와 시도횟수가 들어오면 익셉션을 던진다")
    @CsvSource({"가, 1", "1, 나", "자, 바"})
    @ParameterizedTest
    void wrongInput(String numberOfCar, String numberOfAttempt) {
        assertThatThrownBy(() -> new RacingGameInfo(numberOfCar, numberOfAttempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 대수와 시도횟수는 숫자로 입력해야합니다");
    }

    @DisplayName("자동차 수와 시도횟수에 0이하의 수를 입력하면 익셉션을 던진다")
    @CsvSource({"1, -1", "-1, 1", "-1, -1", "0,0"})
    @ParameterizedTest
    void gameinfo(String numberOfCar, String numberOfAttempt) {
        assertThatThrownBy(() -> new RacingGameInfo(numberOfCar, numberOfAttempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0이하의 수는 입력할 수 없습니다");
    }

}
