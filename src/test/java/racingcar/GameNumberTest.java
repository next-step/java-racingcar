package racingcar;

import racingcar.domain.GameNumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"-1", "10"})
    void newNumber_숫자는_0이상_9이하가_아닌_경우_유효하지_않는다(int invalidNumber) {
        // when then
        assertThatThrownBy(() -> GameNumber.newNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "1:false"}, delimiter = ':') // 4 -> GameNumber.MOVABLE_MIN_NUMBER
    void isMovableNumber_최소값이상인_경우_이동_가능한_번호이다(int number, boolean result) {
        // given
        GameNumber gameNumber = GameNumber.newNumber(number);

        // when
        boolean movableNumber = gameNumber.isMovableNumber();

        // then
        assertThat(movableNumber).isEqualTo(result);
    }
}
