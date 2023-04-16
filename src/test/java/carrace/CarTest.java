package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void move() {
        final Car car = new Car(1);
        car.move(true);
        final int position = car.getPosition();

        assertThat(position).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void moveNotZero() {
        final Car car = new Car(2);
        car.move(true);
        final int position = car.getPosition();

        assertThat(position).isEqualTo(3);
    }
    
    @ParameterizedTest(name = "자동차 이름은 5자 이하만 가능하다. name: {0}")
    @ValueSource(strings = {"", " ", "garde"})
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

    @ParameterizedTest(name = "자동차는 이름을 가질 수 있다, 빈 문자열 혹은 공백을 이름으로 입력하면 기본이름으로 등록된다.")
    @ValueSource(strings = {":CAR_0", "12345:12345"})
    void carHaveNameTest(String token) {
        final String name = token.split(":")[0];
        final String expected = token.split(":")[1];

        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(expected);
    }

    @DisplayName("자동차는 복사할 수 있다.")
    @Test
    void copy() {
        final Car car = new Car();
        final Car copy = car.copy();

        assertThat(copy).isEqualTo(car);
        assertThat(car == copy).isFalse();
    }
}
