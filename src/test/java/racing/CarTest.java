package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_이동_전략패턴() {
        Car carA = new Car("CarA");
        carA.move(() -> true);
        carA.move(() -> true);
        carA.move(() -> true);
        assertThat(carA.isPosition(3)).isTrue();
    }

    @Test
    void 자동차_정지_전략패턴() {
        Car carA = new Car("CarA");
        carA.move(() -> false);
        carA.move(() -> false);
        carA.move(() -> false);
        assertThat(carA.isPosition(0)).isTrue();
    }

    @Test
    void 자동차_이동_생성자_초기화() {
        Car carA = new Car("CarA", 3);
        assertThat(carA.isPosition(3)).isTrue();
    }

    @Test
    void 자동차_정지_생성자_초기화() {
        Car carA = new Car("CarA", 0);
        assertThat(carA.isPosition(0)).isTrue();
    }
}
