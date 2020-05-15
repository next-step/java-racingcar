package step4.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("생성된 값이 4보다 큰 경우에만 position 이 증가한다.")
    @ParameterizedTest
    @CsvSource({"car1,1,0", "car2,4,1", "car3,5,1"})
    public void whenGeneratedNumberGreaterThan4ThenAddPositionTest(String name, int input, int expected){

        // given
        Car car = Car.of(name);
        int movableNum = 4;

        // when
        car.move(() -> input >= movableNum);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
