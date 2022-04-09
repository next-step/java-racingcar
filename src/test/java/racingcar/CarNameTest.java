package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @Test
    @DisplayName("정상 CarName 테스트")
    void carNameTest() {
        CarName carName = new CarName("1234");
        assertThat(carName.getName()).isEqualTo("1234");
    }

    @Test
    @DisplayName("벨리데이션 테스트")
    void validationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("123456"));
    }

}