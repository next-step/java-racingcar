package racing.car.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    private racing.car.model.Car car;

    @Test
    @DisplayName("자동차 이름 5글자 초과인 경우")
    void create_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("august", 0)
        ).withMessageContaining("이름이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("자동차가 움직이는 경우")
    void go() {
        // given
        int firstLocation = 10;
        car = new racing.car.model.Car("lee", firstLocation);

        // when
        car.go();

        // then
        assertThat(car.getLocation()).isEqualTo(firstLocation + 1);
    }
}