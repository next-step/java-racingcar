package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputCars;


@DisplayName("InputCars DTO 테스트")
public class InputCarsTest {

    @Test
    @DisplayName("입력받은 CarsInfo 가 null 이면 NullPointerException 이 발생한다.")
    void inputCarsInfoNullTest() {
        Assertions.assertThatThrownBy(() -> InputCars.fromCarsInfo(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("is null");
    }
}
