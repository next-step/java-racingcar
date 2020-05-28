package racing;

import edu.next.racing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private String carName = "test";
    private Car defaultCar = new TestCar(carName, true);
    private Car immoveableCar = new TestCar(carName, false);
    private int carPostion = 1;

    @DisplayName("자동차 위치 포지션 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1,1,1,1,1 })
    void carOnlyMovePositionTest(int i) {
        carPostion += i;
        defaultCar.move();
        assertThat(defaultCar.getPosition()).isEqualTo(carPostion);
    }

    @DisplayName("자동차 위치 포티션 테스트 2")
    @ParameterizedTest
    @ValueSource(ints = { 1,1,1,1,1 })
    void carOnlyStopPositionTest(int i) {
        immoveableCar.move();
        assertThat(immoveableCar.getPosition()).isEqualTo(i);
    }

    @DisplayName("자동차 이름 테스트")
    @Test
    void carNameTest() {
        assertThat(defaultCar.getName()).isEqualTo(carName);
    }
}
