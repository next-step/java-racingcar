package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("초기 위치는 0이다")
    public void carInitialPosition_Zero() {
        Car car = new Car();
        assertThat(car.position).isZero();
    }

    @Test
    @DisplayName("1씩 이동한다")
    public void carMoveAtOnce_One() {
        Car car = new Car();
        Integer BeforePosition = car.position;
        car.move();
        Integer AfterPosition = car.position;
        assertThat(AfterPosition - BeforePosition).isOne();
    }

    @Test
    @DisplayName("MINIMUM_NUMBER_TO_MOVE 이상일 때 이동한다")
    public void carMove_WhenNumberMoreThanEqualMinimumNumberToMove() {
        assertThat(Car.isMovable(Car.MINIMUM_NUMBER_TO_MOVE)).isTrue();
    }

    @Test
    @DisplayName("MINIMUM_NUMBER_TO_MOVE 미만일 때 이동하지 않는다")
    public void carMove_WhenNumberLessThanMinimumNumberToMove() {
        assertThat(Car.isMovable(Car.MINIMUM_NUMBER_TO_MOVE - 1)).isFalse();
    }
}
