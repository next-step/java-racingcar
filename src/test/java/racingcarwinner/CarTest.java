package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcarwinner.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcarwinner.domain.Car.createDefaultCar;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @DisplayName("input 으로 받은 자동차 이름의 길이가 5글자를 초과하면 exception 을 던진다.")
    @ParameterizedTest
    @CsvSource(value = {"'abcde,abc'", "'a,b,c,defgh"})
    void 자동차_이름_5글자_초과_시_exception(String input) {
        assertThatThrownBy(() -> createDefaultCar(input)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void move_수행_후_location_증가() {
        Car car = new Car("test", 1);
        car.move(() -> true);
        assertThat(car.location()).isEqualTo(2);
    }

    @Test
    void move_수행_후_location_유지() {
        Car car = new Car("test", 1);
        car.move(() -> false);
        assertThat(car.location()).isEqualTo(1);
    }
}