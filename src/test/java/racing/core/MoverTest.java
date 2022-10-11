package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoverTest {

    private final Mover mover = new Mover();

    @Test
    @DisplayName("4 이하의 값이 주어졌을 때 자동차를 움직이는지 확인")
    void testIfMoveWithUnder4() {
        int inputNum = 3;
        Car car = new Car("jack");
        mover.decideMove(car, inputNum);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 이상의 값이 주어졌을 때 자동차가 멈춰있는지 확인")
    void testIfMoveWithOver4() {
        int inputNum = 7;
        Car car = new Car("jack");
        mover.decideMove(car, inputNum);
        assertThat(car.getDistance()).isEqualTo(2);
    }

}
