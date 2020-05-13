package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputValueDtoTest {

    @DisplayName("InputView에서 입력받은 값이 숫자가 아니면 IllegalArgumentException Throw")
    @ParameterizedTest
    @CsvSource({"가,1", "1,나", "가,나"})
    void ThrowException(String numberOfCar, String numberOfPhase) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputValueDto(numberOfCar, numberOfPhase))
                .withMessage("자동차 대수와 시도 회수는 숫자여야 합니다.");
    }
}
