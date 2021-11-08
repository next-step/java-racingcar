package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("값은 0 이하 값이 들어오면 안된다")
    void inputValidation(int value) {
        assertThatThrownBy(() -> new Cars(value))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new Cars(1))
                .doesNotThrowAnyException();
    }

}
