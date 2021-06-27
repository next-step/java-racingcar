package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @DisplayName("자동차는 이름을 가진다.")
    @ParameterizedTest
    @ValueSource(strings = {"hyeon"})
    public void car(String name) {
        assertThat(new Car(name)).isInstanceOf(Car.class);
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jeonggggg"})
    public void invalidedName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @DisplayName("자동차는 이동한다.")
    @ParameterizedTest
    @ValueSource(strings = {"hyeon"})
    public void moveTest(String name) {
        Car car = new Car(name);
        car.move(true);
        car.move(true);

        assertThat(car.getLocation()).isEqualTo(2);
    }

    @DisplayName("자동차는 이동하지않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"hyeon"})
    public void notMoveTest(String name) {
        Car car = new Car(name);
        car.move(false);

        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("우승위치가 car 객체의 위치인가를 알 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    public void isSameLocationTest(int location) {
        Car car = new Car("hyeon");
        car.move(true);
        car.move(true);

        assertThat(car.isSameLocation(location)).isTrue();
    }
}
