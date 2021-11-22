package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"helloo", "modernjava", "testtest"})
    void 자동차이름_5자초과_예외(String input) {
        assertThatThrownBy(() -> {
            new CarName(input);
        }).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}
