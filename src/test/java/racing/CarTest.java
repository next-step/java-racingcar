package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "조건에 따라 1칸 전진하는지 확인하는 테스트")
    @CsvSource(value = {"true:1 ", "false:0"}, delimiter = ':')
    void 전진_기능_테스트(boolean condition, Long expected) {
        Car car = new Car();
        car.forward(condition);

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
