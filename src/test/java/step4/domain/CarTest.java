package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int TEN = 10;

    private Car car = new Car("testCar", TEN);

    @Test
    void 자동차는_이름으로_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_최초위치는_0이다() {
        Car newCar = new Car("newCar");
        assertThat(newCar.getPosition()).isEqualTo(Position.INITIAL_POSITION);
    }

    @Test
    void 자동차의_이름을_반환한다() {
        assertThat(car.getName()).isEqualTo("testCar");
    }

    @Test
    void 자동차가_이동한_이후의_위치를_구한다() {
        assertThat(car.getPosition()).isEqualTo(TEN);
    }

    @Test
    void 우승한_자동차인지_판단한다() {
        int winnerPosition = TEN;
        assertThat(car.isSamePosition(winnerPosition)).isTrue();
    }
}
