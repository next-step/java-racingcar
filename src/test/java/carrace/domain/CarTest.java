package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void move() {
        final Car car = new Car("a", 1);
        car.move(true);
        final int position = car.getPosition();

        assertThat(position).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void moveNotZero() {
        final Car car = new Car("b", 2);
        car.move(true);
        final int position = car.getPosition();

        assertThat(position).isEqualTo(3);
    }
    
    @ParameterizedTest(name = "자동차 이름은 5자 이하만 가능하다. name: {0}")
    @ValueSource(strings = {"1", "12", "garde"})
    void createWithNameUnderFiveTest(String name) {
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "자동차 이름은 5자 이하만 가능하다. name: {0}")
    @ValueSource(strings = {"123456", "garden2"})
    void createWithNameOverFiveTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest(name = "자동차는 이름을 가질 수 있다")
    @ValueSource(strings = {"CAR:CAR", "12345:12345"})
    void carHaveNameTest(String token) {
        final String name = token.split(":")[0];
        final String expected = token.split(":")[1];

        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "자동차는 빈문자열이나 공백을 이름으로 가질 수 없다")
    @ValueSource(strings = {"", "  "})
    void carDoesNotHaveEmptyName(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(carName));
    }

    @DisplayName("자동차는 복사할 수 있다.")
    @Test
    void copy() {
        final Car car = new Car("a");
        final Car copy = car.copy();

        assertThat(copy).isEqualTo(car);
        assertThat(car == copy).isFalse();
    }
}
