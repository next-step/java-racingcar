package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class SpeedUtilsTest {

    @DisplayName("possibleMoveSpeed() 테스트")
    @ParameterizedTest(name = "[{index}] Speed {0}은 앞으로 전진할 수 있다 -> {1}")
    @CsvSource(value = {
            "0, false", "1, false", "2, false", "3, false",
            "4, true", "5, true", "6, true", "7, true", "8, true", "9, true",
    })
    void possibleMoveSpeed(int speed, boolean expectedResult) {
        boolean result = SpeedUtils.possibleMoveSpeed(speed);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("getRandomSpeed() 테스트 -> random speed는 0이상 9이하의 수이어야 한다.")
    @Test
    void getRandomSpeed() {
        int result = SpeedUtils.getRandomSpeed();

        assertThat(result).isBetween(0, 9);
    }
}
