package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하면, 에러가 발생한다.")
    void carNameShouldNotExceed5() {
        assertThatThrownBy(() -> new Car("flower")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 객체를 생성한다.")
    void getValue() {
        assertThat(new CarName("luna").getValue()).isEqualTo("luna");
    }
}