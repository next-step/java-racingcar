package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차 이름이 5자리 이상이면 에러")
    @Test
    void checkNameValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("aaaaaa"));
    }

    @DisplayName("go로 전달되는 숫자가 4보다 크면 score가 1 올라가야한다.")
    @Test
    void go() {
        Car car = new Car("test");
        car.go(7);
        assertThat(car.getScore()).isEqualTo(1);
    }
}
