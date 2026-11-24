package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차의 초기 위치는 0이다")
    @Test
    void initialPosition() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("값이 4 이상이면 전진하고 3 이하면 전진하지 않는다")
    @ParameterizedTest(name = "값이 {0} 이면 위치는 {1}")
    @CsvSource({"4,1", "3,0"})
    void move(int number, int expected) {
        Car car = new Car("pobi");

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차는 5자 이하의 이름을 가진다")
    @ParameterizedTest(name = "\"{0}\"")
    @ValueSource(strings = {"pobi", "crong"})
    void hasName(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다")
    @Test
    void tooLongName() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
