package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차가 전진하여 위치가 1 증가한다.")
    void 자동차_전진() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("전달받은 숫자가 4 이상일 때 true, 4 미만이라면 false를 반환한다.")
    @CsvSource(value = {"4:true", "3:false", "5:true", "1:false"}, delimiter = ':')
    void 숫자_판단(int input, boolean expected) {
        Car car = new Car();
        assertThat(car.isAtLeastBaseNumber(input)).isEqualTo(expected);
    }
}
