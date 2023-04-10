package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "4:----"}, delimiter = ':')
    @DisplayName("distanceToString()은 distance의 수만큼 -를 출력한다.")
    void contains(int num, String expected) {
        Car car = new Car(num, 1, 0);
        for (int i = 1; i <= num; i++) {
            car.move();
        }
        assertThat(car.distanceToString()).isEqualTo(expected);
    }


}