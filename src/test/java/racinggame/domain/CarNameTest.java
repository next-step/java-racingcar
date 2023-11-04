package racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarNameTest {

    @ParameterizedTest(name = "자동차 이름에는 {0}이 허용 되지 않는다")
    @NullAndEmptySource
    void 자동차_이름에는_null_혹은_공백이_허용_되지_않는다(String input) {
        new CarName(input);
        assertThrows(RuntimeException.class, () -> new CarName(input));
    }

}
