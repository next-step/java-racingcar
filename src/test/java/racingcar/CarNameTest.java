package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("정상적인 자동차 이름의 객체 생성을 테스트한다")
    void carNameTest() {
        CarName carName = new CarName("1234");
        assertThat(carName.getName()).isEqualTo("1234");
    }

    @Test
    @DisplayName("잘못된 입력 값의 경우 예외를 발생시킨다")
    void validationTest() {
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(InvalidCarNameException.class);
    }

}