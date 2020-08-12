package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 자동차_생성_성공() {
        Car car = new Car("애플");
        assertThat(car.getStatus()).isEqualTo(1);
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_임의상태값_성공() {
        Car car = new Car("삼성", 3);
        assertThat(car.getStatus()).isEqualTo(3);
    }

    @Test
    void 자동차_임의이동_성공() {
        Car car = new Car("구글");
        car.move(1);
        assertThat(car.getStatus()).isGreaterThanOrEqualTo(2);
    }

}