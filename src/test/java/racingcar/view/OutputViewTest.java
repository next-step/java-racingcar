package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @ParameterizedTest
    @DisplayName("위치에 따른 대쉬 출력 확인")
    @CsvSource({"1,-", "3,---", "5,-----"})
    void checkDashOutputLengthAccordingPosition(int input, String expected) {
        assertThat(OutputView.getDashOnDistanceByCars(input)).isEqualTo(expected);
    }
}