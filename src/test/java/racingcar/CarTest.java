package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Score;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤 값이 4 이상이면 자동차는 1만큼 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 자동차_전진(int randomValue) {
        Car car = new Car("pobi");

        Car moved = car.move(randomValue);

        assertThat(moved.equals(new Car(new Name("pobi"), new Score(1)))).isTrue();
    }

    @DisplayName("랜덤 값이 3 이하면 자동차는 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 자동차_정지(int randomValue) {
        Car car = new Car("pobi");

        Car moved = car.move(randomValue);

        assertThat(moved.equals(new Car(new Name("pobi"), new Score(0)))).isTrue();
    }
}
