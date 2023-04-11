package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("전진/후진 판별 메서드 엣지 케이스 테스트")
    @Test
    public void testGoOrStopTest() {
        Car car = new Car();
        Car.RANDOM_BOUND = 1;
        Car.THRESHOLD = 0;
        assertThat(car.testGoOrStop()).isTrue();

        car.goOrStop();
        assertThat(car.getTrace()).isEqualTo("--");

        Car.THRESHOLD = 2;
        assertThat(car.testGoOrStop()).isFalse();

        car.goOrStop();
        assertThat(car.getTrace()).isEqualTo("--");
    }

    @DisplayName("각각의 차가 경주한 정도가 옳게 되었는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    public void plusTraceTest(int count) {
        Car car = new Car();
        StringBuilder expected = new StringBuilder("-");

        for (int i = 0; i < count; i++) {
            car.plusTrace();
            expected.append("-");
        }

        assertThat(car.getTrace()).isEqualTo(expected.toString());
    }

}