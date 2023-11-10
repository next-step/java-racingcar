package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcarwinner.Car.createDefaultCar;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @DisplayName("input 으로 받은 자동차 이름의 길이가 5글자를 초과하면 exception 을 던진다.")
    @ParameterizedTest
    @CsvSource(value = {"'abcde,abc'", "'a,b,c,defgh"})
    void 자동차_이름_5글자_초과_시_exception(String input) {
        assertThatThrownBy(() -> createDefaultCar(input)).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("move 수행 횟수 만큼 location 증가")
    @ParameterizedTest
    @CsvSource(value = {"3,4", "5,6"})
    void move_수행_후_location_증가(int input, int expected) {
        Car car = new Car("test", 1);
        IntStream.range(0, input).forEach(i -> car.move(4));
        assertThat(car.getLocation()).isEqualTo(expected);
    }
}