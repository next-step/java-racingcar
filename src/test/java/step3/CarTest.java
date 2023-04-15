package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Test
    void 자동차_이동시_위치변경() {
        car.move(5);
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_여러번_이동시_위치변경_누적() {
        car.move(5);
        car.move(2);
        car.move(3);
        assertThat(car.location()).isEqualTo(10);
    }

    @Test
    void 자동차_멈추면_위치변경_없음() {
        car.move(5);
        assertThat(car.location()).isEqualTo(5);
        car.stop();
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_현재위치_반환() {
        assertThat(car.location()).isEqualTo(0);
        car.move(1);
        assertThat(car.location()).isEqualTo(1);
    }
}
