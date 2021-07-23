package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @Test
    void 주어진_숫자가_특정RPM이상이면_자동차의_moveCount는_증가한다() {
        int givenRpm = 4;
        Car car = new Car(new CarEngine());
        car.move(givenRpm);

        assertThat(car.getMovedCount()).isEqualTo(1);
    }

    @Test
    void 주어진_숫자가_특정RPM_이하이면_자동차의_moveCount는_변동이_없다() {
        int givenRpm = 3;
        Car car = new Car(new CarEngine());
        car.move(givenRpm);

        assertThat(car.getMovedCount()).isEqualTo(0);
    }
}
