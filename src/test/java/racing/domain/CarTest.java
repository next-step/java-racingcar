package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_이동_전략패턴() {
        Car carA = new Car("CarA");
        carA.move(() -> true);
        carA.move(() -> true);
        carA.move(() -> true);
        assertThat(carA.getPosition()).isEqualTo(3);
    }

    @Test
    void 자동차_정지_전략패턴() {
        Car carA = new Car("CarA");
        carA.move(() -> false);
        carA.move(() -> false);
        carA.move(() -> false);
        assertThat(carA.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_값_생성자_초기화() {
        Car carA = new Car("CarA", 3);
        assertThat(carA.getPosition()).isEqualTo(3);
    }

    @Test
    void 자동차_정지_값_생성자_초기화() {
        Car carA = new Car("CarA", 0);
        assertThat(carA.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_정지_기본_생성자() {
        Car carA = new Car("CarA");
        assertThat(carA.getPosition()).isEqualTo(0);
    }

    @Test
    void 우승_Position_값_비교() {
        assertThat(new Car("CarA", 5).isWinnerPosition(9)).isFalse();
        assertThat(new Car("CarB", 9).isWinnerPosition(4)).isTrue();
    }

}
