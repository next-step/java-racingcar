package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 자동차는_1대_이상_10대_이하로_제한한다(String input) {
        assertThatCode(() -> new Cars(input.split(","))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9,10,11"})
    void 자동차는_1대_미만_10대_초과하여_설정할_수_없다(String input) {
        assertThatThrownBy(() -> new Cars(input.split(",")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 수는 1 ~ 10대 사이로 설정해야 합니다.");

    }
}