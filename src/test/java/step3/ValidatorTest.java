package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ValidatorTest {

    @DisplayName("자동차이름이 5자를 초과하면 false 를 반환한다.")
    @Test
    public void validateInputCarsNameLength_ShouldReturnFalse() {
        String[] carsName = {"test1", "test12", "test3"};

        assertThat(Validator.isValidateCarsNameLength(carsName)).isFalse();
    }

    @DisplayName("자동차이름이 5자 이하이면 True 를 반환한다.")
    @Test
    public void validateInputCarsNameLength_ShouldReturnTrue() {
        String[] carsName = {"test1", "test2", "test3"};

        assertThat(Validator.isValidateCarsNameLength(carsName)).isTrue();
    }
}
