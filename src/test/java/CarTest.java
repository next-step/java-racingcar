import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가질 수 있다.")
    void carHasName() {
        Car car = new Car("MyCar");
        assertThat(car.getName()).isEqualTo("MyCar");
    }

    @Test
    @DisplayName("자동차 이름은 빈 문자열이 될 수 없다")
    void carNameCannotBeEmpty() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be blank");
    }

    @Test
    @DisplayName("자동차 이름은 공백만으로 구성될 수 없다")
    void carNameCannotBeBlank() {
        assertThatThrownBy(() -> new Car("   ")).isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be blank");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void carNameCannotExceed5Characters() {
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be longer than 5 characters");
    }

    @ParameterizedTest
    @DisplayName("random값이 4 이상일 경우에 자동차의 위치는 1 추가되고, 4 미만일 경우 위치가 변하지 않는다")
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    void carMovesAccordingToRandomValue(int seed, int expectedPosition) {
        Car car = new Car("MyCar");
        car.move(seed);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @DisplayName("이동을 위한 숫자는 0에서 9 사이여야 한다")
    @ValueSource(ints = {-1, 10})
    void carMoveVariableIsBetween0And9(int invalidSeed) {
        Car car = new Car("MyCar");
        assertThatThrownBy(() -> car.move(invalidSeed)).isInstanceOf(IllegalArgumentException.class).hasMessage("Invalid seed: " + invalidSeed);
    }
}
