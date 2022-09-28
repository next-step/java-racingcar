package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("숫자로 자동자 이동 여부 검증")
    public void movableCar(int num, boolean expected) {
        boolean result = RacingGame.isMovable(num);
        assertThat(result).isEqualTo(expected);
    }
}