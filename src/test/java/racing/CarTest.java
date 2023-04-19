package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName(value = "자동차 이름은 5자를 초과할 수 없다.(5자이상 자름)")
    @CsvSource(value = {"12345, 12345", "123456, 12345", "다섯글자초과, 다섯글자초", "test, test"})
    void carNameTest(String inputName, String expectedName) {
        Car car = new Car(inputName);
        assertThat(car.valueOfName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "3, 1", "4, 2", "9, 2"})
    void carRaceTest(int randomNumber, int expectedPosition) {
        Car car = new Car("test");
        car.race(randomNumber);
        assertThat(car.valueOfCurrentPosition()).isEqualTo(expectedPosition);
    }
}
