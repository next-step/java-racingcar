package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 테스트")
    void carNameTest() {
        String name = "hello";
        CarName carName = new CarName(name);
        assertThat(carName).isEqualTo(new CarName(name));
    }

    @Test
    @DisplayName("자동차이름은 5글자를 넘을 수 없습니다.")
    void validateCarNameTest() {
        String name = "Hello1";
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차이름은 Null이 될 수 없습니다.")
    void nullTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(input));
    }
}
