package racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racinggame.domain.exception.InputIsBlankException;
import racinggame.domain.exception.InputOverFiveLengthException;

class CarNameTest {

    @ParameterizedTest(name = "자동차 이름에는 {0}이 허용 되지 않는다")
    @NullAndEmptySource
    void 자동차_이름에는_null_혹은_공백이_허용_되지_않는다(String input) {
        assertThrows(InputIsBlankException.class, () -> new CarName(input));
    }

    @Test
    void 자동차_이름은_5자를_초과_할_수_없다() {
        assertThrows(InputOverFiveLengthException.class, () -> new CarName("sixsix"));
    }

}
