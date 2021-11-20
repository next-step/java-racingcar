package step4.dto.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.dto.RandomStrategy;
import step4.dto.count.Count;
import step4.dto.count.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 10, 12})
    @DisplayName("4 이상의 값을 인자로 넘길 경우 자동차는 전진한다")
    public void carRunTest(int input) {
        Car car = new Car(new RandomStrategy(), "dy");

        car.run(new Count(input));

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 값을 인자로 넘길 경우 자동차는 움직이지 않는다")
    public void carStopTest(int input) {
        Car car = new Car(new RandomStrategy(), "dy");

        car.run(new Count(input));

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

}