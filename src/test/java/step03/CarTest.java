package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step03.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:56 오후
 */
class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 4, 6})
    @DisplayName("Car 이동 테스트")
    public void moveTest(int moveCount) {
        final Car car = new Car();
        car.AdvanceOneSpace(moveCount);
        assertThat(car.getMoveCount()).isEqualTo(1);

    }
}