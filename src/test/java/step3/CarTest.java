package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @DisplayName("각각의 차가 전진했을 때, 전진한 정도가 맞는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    void plusTraceTest(int count) {
        Car car = new Car();
        int expected = 0;
        for (int i = 0; i < count; i++) {
            car.plusTrace();
            expected += 1;
        }

        assertThat(car.getTrace()).isEqualTo(expected);
    }
}
