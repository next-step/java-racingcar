package racing;

import edu.next.racing.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private String carName = "test";
    private Car car = new TestCar(carName);
    private Car immovableCar = new ImmovableCar(carName);
    private int carPostion = 1;

    @DisplayName("자동차 위치 포지션 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1,1,1,1,1 })
    void carOnlyMovePositionTest(int i) {
        carPostion += i;
        car.move();
        assertThat(car.getPosition()).isEqualTo(carPostion);
    }

    @DisplayName("자동차 위치 포티션 테스트 2")
    @ParameterizedTest
    @ValueSource(ints = { 1,1,1,1,1 })
    void carOnlyStopPositionTest(int i) {
        immovableCar.move();
        assertThat(immovableCar.getPosition()).isEqualTo(i);
    }

    @DisplayName("자동차 이름 테스트")
    @Test
    void carNameTest() {
        assertThat(car.getName()).isEqualTo(carName);
    }
}
