package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName(value = "Car 최초 생성")
    @Test
    void 자동차_최초_생성() {
        // given
        Car car = new Car("dugi");

        // then
        assertThat(car).isEqualTo(new Car("dugi"));
    }

    @DisplayName(value = "car1 최초 생성 후 car1이 move한 후, 본인의 필드를 새로운 객체로 반환한다.")
    @Test
    void 자동차_최초_이후_생성() {
        // given
        Car car1 = new Car("dugi");

        // when
        Car car2 = car1.move(() -> true);

        // then
        assertThat(car2).isEqualTo(car1);
    }

    @DisplayName(value = "전신 성공 테스트")
    @Test
    void 전진_성공() {
        // given
        Car car = new Car("dugi");

        // when
        car.move(() -> true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName(value = "전신 실패 테스트")
    @Test
    void 전진_실패() {
        // given
        Car car = new Car("dugi");

        // when
        car.move(() -> false);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}