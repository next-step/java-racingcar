package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자이상"})
    @DisplayName("자동차 생성 실패")
    public void createFail(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1"}, delimiter = ':')
    @DisplayName("주사위 숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    public void moveTest(int input, int expect) {
        Car car = new Car("test");
        NumberBasedCarMover carMover = new FixedNumberBasedCarMover(input);
        int distance = carMover.move();
        car.move(distance);

        assertThat(car.position()).isEqualTo(expect);
    }
}
