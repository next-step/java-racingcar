package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.car.Name;
import racinggame.exception.CarException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racinggame.exception.ErrorMessage.INVALID_CAR_NAME;

class NameTest {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나다라마"})
    @DisplayName("[성공] 이름은 1자이상 5자이하일 경우 생성이 가능하다.")
    void 생성테스트_01(final String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("[실패] 이름이 빈 값일 경우 생성이 불가하다.")
    void 생성테스트_02(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(CarException.class)
                .hasMessageContaining(INVALID_CAR_NAME.getMessage(NAME_MIN_LENGTH, NAME_MAX_LENGTH));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바", "사아자차카타파하"})
    @DisplayName("[실패] 이름이 5자 초과할 경우 생성이 불가하다.")
    void 생성테스트_03(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(CarException.class)
                .hasMessageContaining(INVALID_CAR_NAME.getMessage(NAME_MIN_LENGTH, NAME_MAX_LENGTH));
    }

}
