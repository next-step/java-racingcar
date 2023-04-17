package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.generator.MovableNumberGenerator;
import racingcar.generator.NonMovableNumberGenerator;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.*;

class RacingTest {
    @Test
    void racing_한대_시도한번() {
        Racing racing = new Racing(1,1);
        racing.excute(new MovableNumberGenerator());
    }

    @Test
    void racing_한대_시도두번() {
        Racing racing = new Racing(1,2);
        racing.excute(new MovableNumberGenerator());
    }

    @Test
    void racing_여러대_시도여러번() {
        Racing racing = new Racing(3,5);
        racing.excute(new MovableNumberGenerator());
    }

    @Test
    void resultView_printMovementTest() {
        assertThat(ResultView.printMovement(3)).isEqualTo("---");
    }

    @Test
    void carMoveTest_by_movableNumberGenerator() {
        Car car = new Car();
        assertThat(CarController.move(car, new MovableNumberGenerator())).isEqualTo("-");
    }

    @Test
    void carMoveTest_by_nonMovableNumberGenerator() {
        Car car = new Car();
        assertThat(CarController.move(car, new NonMovableNumberGenerator())).isEqualTo("");
    }


}