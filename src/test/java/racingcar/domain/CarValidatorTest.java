package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarValidatorTest {

    @DisplayName("5자를 초과하는 이름은 IllegalArgumentException 을 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "알이삼사오육칠", "가나다라마바사"})
    void verifyNameLength_onFail(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarValidator.verifyNameLength(name))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
