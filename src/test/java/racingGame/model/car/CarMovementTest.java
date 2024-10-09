package racingGame.model.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovementTest {

    @Test
    public void add_성공_테스트() {
        Cars obj = Cars.createCars(3);
        CarMovement expected = new CarMovement();

        expected.addOneStepProgress(obj);

        assertThat(expected.getProgress().size()).isEqualTo(1);
    }
}
