import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Name cannot be longer than 5 characters");
    }

    @ParameterizedTest
    @DisplayName("shouldMove가 true일 경우 자동차의 위치는 1 추가되고, false일 경우 위치가 변하지 않는다")
    @CsvSource({"false, 0", "true, 1"})
    void carMovesAccordingToShouldMove(boolean shouldMove, int expectedPosition) {
        Car car = new Car("MyCar");
        car.move(shouldMove);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
