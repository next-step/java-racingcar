package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputValueDtoTest {

    @DisplayName("InputView에서 입력받은 값이 1보다 작으면 IllegalArgumentException Throw")
    @ParameterizedTest
    @CsvSource({"-1,1", "1,-1", "-1,-1"})
    void ThrowException(int numberOfCar, int numberOfPhase) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputValueDto(numberOfCar, numberOfPhase))
                .withMessageContaining("0 보다 커야합니다.");
    }
}
