package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartViewTest {
    @DisplayName("isValidCarNum : carNum 입력 유효성 검사 - 최소값 미만이면 false")
    @ParameterizedTest
    @CsvSource({"0, false", "-1, false", "1, true", "10, true"})
    void isValidCarNum(int input, boolean expected) {
        assertThat(StartView.isValidCarNum(input)).isEqualTo(expected);
    }

    @DisplayName("isValidRoundNum : RoundNum 입력 유효성 검사 - 최소값 미만이면 false")
    @ParameterizedTest
    @CsvSource({"0, false", "-1, false", "1, true", "10, true"})
    void isValidRoundNum(int input, boolean expected) {
        assertThat(StartView.isValidRoundNum(input)).isEqualTo(expected);
    }
}
