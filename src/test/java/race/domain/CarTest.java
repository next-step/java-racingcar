package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(1, "임형준");
    }

    @DisplayName("go메서드의 인자(randomNumber)를 고정해 움직인 거리를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:4", "3:1"}, delimiter = ':')
    void go_three_times(int randomNumber, int expected) {
        car.go(randomNumber);
        car.go(randomNumber);
        car.go(randomNumber);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

}
