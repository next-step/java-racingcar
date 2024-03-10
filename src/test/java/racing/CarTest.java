package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("number 4일 경우 - 을반환한다")
    void testRunMethodReturnsDash(int number) {
        Car car = new Car();
        String text = car.run(number);
        assertThat(text).isEqualTo("-");
    }

    @ParameterizedTest()
    @ValueSource(ints = {5, 6, 7})
    @DisplayName("number가 5일 경우 빈 문자열을 반환한다. ")
    void testRunMethodReturnsEmpty(int number) {
        Car car = new Car();
        String text = car.run(number);
        assertThat(text).isEqualTo("");
    }

    @Test
    @DisplayName("1,4,5 값을 줄경우 --를 반환한다.")
    void testRunMethodReturnsDoubleDash() {
        Car car = new Car();
        car.run(1);
        car.run(4);
        String text = car.run(5);
        assertThat(text).isEqualTo("--");
    }
}