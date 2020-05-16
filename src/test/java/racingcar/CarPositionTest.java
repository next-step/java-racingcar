package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarPosition;

import static org.assertj.core.api.Assertions.*;

public class CarPositionTest {

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    @DisplayName("CarPosition 생성 테스트")
    void generateCarPositionTest(int position) {
        assertThatCode(() -> CarPosition.of(position)).doesNotThrowAnyException();
    }

    @ValueSource(ints = {-1, -2, -3})
    @ParameterizedTest
    @DisplayName("CarPosition 생성 예외 테스트")
    void generateCarPositionExceptionTest(int position) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarPosition.of(position));
    }

}
