package racingcar.validate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.validate.CarValidate.validateCarName;
import static racingcar.validate.CarValidate.validateCarsName;

public class CarValidateTest {
    @Test
    void 자동차이름들_유효성_검사() {
        String carsName = "애플,삼성,구글";
        String[] carsArray = validateCarsName(carsName);
        assertEquals(3, carsArray.length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 자동차이름_한글자이상_다섯글자이하_검사(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> validateCarName(name))
                .withMessage("자동차 이름은 최소 1자 이상 5자 이하여야 합니다");
    }
}
