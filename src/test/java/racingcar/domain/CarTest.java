package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차는_4_이상_숫자를_입력하면_전진한다() {
        Car car = new Car();
        assertThat(car.decideAction(4)).isEqualTo(CarAction.GO_FORWARD);
        assertThat(car.decideAction(9)).isEqualTo(CarAction.GO_FORWARD);
        assertThat(car.decideAction(0)).isEqualTo(CarAction.STOP);
        assertThat(car.decideAction(1)).isEqualTo(CarAction.STOP);
    }

    @Test
    void 자동차는_전진_하거나_멈춘다() {
        Car car = new Car();
        int prevPosition = car.getPosition();

        car.act();
        
        assertThat(car.getPosition()).isIn(prevPosition, prevPosition + 1);
    }

    @Test
    void 자동차는_현재_위치를_나타낸다() {
        assertThat(new Car().getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_전진하면_위치가_1_증가한다() {
        Car car = new Car();
        int prevPosition = car.getPosition();

        car.goForward();

        assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
    }
}
