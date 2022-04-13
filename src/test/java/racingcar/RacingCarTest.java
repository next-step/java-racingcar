package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {


    @Test
    @DisplayName("음수값 입력 테스트")
    void 자동차경주_테스트() {
        int result = InputView.enterTheNumberOfCars();

    }
}
