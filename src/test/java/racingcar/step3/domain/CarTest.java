package racingcar.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-02 오전 10:11
 * Developer : Seo
 */
class CarTest {

    Car car = null;

    @BeforeEach
    void setUp() {
        car = new Car("0");
    }

    @Test
    @DisplayName("이름")
    void getName() {
        assertThat(car.getName()).isEqualTo("0");
    }

    @Test
    @DisplayName("이동 후 거리 확인")
    void whenMove_thenGetDistance() {
        this.car.move();
        assertThat(car.getDistance()).isEqualTo(1);

        this.car.move();
        assertThat(car.getDistance()).isEqualTo(2);
    }
}