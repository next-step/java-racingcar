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

    @DisplayName("자동차는 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"hyeon"})
    public void moveTest(String name) {
        Car car = new Car(name);

        car.move(true);
        car.move(true);
        car.move(false);

        assertThat(car.getLocation()).isEqualTo(2);
    }

    @DisplayName("우승자를 알 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"hyeon"})
    public void compareWinnerTest(String name) {
        Car car = new Car(name);

        car.move(true);
        car.move(true);
        car.move(false);

        assertThat(car.isWinner(car.getLocation())).isTrue();
    }
}
