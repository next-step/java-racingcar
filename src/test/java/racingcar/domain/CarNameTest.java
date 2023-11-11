package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름을 생성한다, 이름이 5자리가 넘거나, null 이면 예외가 발생한다.")
    void create() {
        assertThat(new CarName("A").value()).isEqualTo("A");
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(RuntimeException.class);
    }
}