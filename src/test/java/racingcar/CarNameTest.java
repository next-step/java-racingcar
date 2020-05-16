package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @ValueSource(strings = {"ray", "genesis"})
    @ParameterizedTest
    @DisplayName("CarName 생성 테스트")
    void generateCarNameTest(String name) {
        assertThatCode(() -> CarName.of(name)).doesNotThrowAnyException();
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("CarName 생성 예외 테스트")
    void generateCarPositionExceptionTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.of(name));
    }
}
