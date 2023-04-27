package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.RacingProcess;
import racingcar.model.Constant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.Constant.IntegerConstant.NEGATIVE_ONE;
import static racingcar.model.Constant.IntegerConstant.POSITIVE_ONE;

public class RacingCarProcessTest {
    private static final String TEST_CAR_NAME = "carTest";

    @Test
    void 음수입력시_예외처리() {
        {
            assertThatThrownBy(() -> new RacingProcess(TEST_CAR_NAME, NEGATIVE_ONE))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage(Constant.Exceptions.DO_NOT_INPUT_NEGATIVE);
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_미입력시_예외처리(String input) {
        assertThatThrownBy(() -> new RacingProcess(input, POSITIVE_ONE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Exceptions.CAR_NAME_MUST_NOT_BE_NULL);
    }

}
