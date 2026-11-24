package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "pobi", "crong"})
    @DisplayName("5자 이하의 이름으로 생성할 수 있다")
    void createWithValidName(String name) {
        CarName carName = new CarName(name);

        assertThat(carName.value()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "toolongname"})
    @DisplayName("이름이 5자를 초과하면 IllegalArgumentException")
    void throwsExceptionWhenNameIsTooLong(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name))
                .withMessage("too long for name [" + name + "]");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("이름이 null이거나 공백이면 IllegalArgumentException")
    void throwsExceptionWhenNameIsBlank(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name))
                .withMessage("valid name is required [" + name + "]");
    }
}
