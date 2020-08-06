package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 차_이동시_최소거리_이상_확인() {
        Car car = new Car("monds");
        int distance = car.getDistance();
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(distance);
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(distance + 1);
    }

    @Test
    void 최종_이동거리_확인() {
        Car car = new Car("monds");
        car.move(9);
        car.move(9);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void 자동차에_이름_부여() {
        String name = "monds";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 특정_길이_이상의_이름_부여() {
        expectIllegalArgumentException("nameee");
    }

    @Test
    void 자동차_이름에_blank_부여() {
        expectIllegalArgumentException(null);
        expectIllegalArgumentException("");
        expectIllegalArgumentException("  ");
    }

    private void expectIllegalArgumentException(String carName) {
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
