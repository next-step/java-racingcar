package racingcarRefactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarRefactor.domain.CarValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarValidatorTest {

    @Test
    @DisplayName("잘못된 자동차 이름 테스트")
    public void carNameValidatorTest() {
        assertThatThrownBy(() -> CarValidator.carNameChecker("apple,aaaaaa")).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자가 넘을 수 없습니다.");
        assertThatThrownBy(() -> CarValidator.carNameChecker("apple,watermelon")).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자가 넘을 수 없습니다.");
    }

}
