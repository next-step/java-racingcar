package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(0, "임형준");
    }

    @DisplayName("차가 한번 전진할 때 1만큼 움직인다는 것을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2","3:3"}, delimiter = ':')
    void go_three_times(int times, int expected) {
        for (int i = 0; i < times; i++) {
            car.go();
        }
        assertThat(car.getPosition()).isEqualTo(expected);
    }

}
