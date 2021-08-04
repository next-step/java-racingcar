package stage3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {
    private CarApplication ca;
    private Car car;

    @BeforeAll
    void setup() {
        ca = new CarApplication();
        car = new Car();
    }

    @Test
    @DisplayName("전진 조건 테스트")
    void forwardConditionTest() {
        int minValue = 0;
        int maxValue = 9;
        int result = car.getForwardCondition();
        assertTrue(result >= minValue && result <= maxValue);
    }

    @Test
    @DisplayName("전진 조건 얻기 - 전진")
    void tryTest1() {
        int condition = 4;
        boolean result = car.isForward(condition);
        assertTrue(result);
    }

    @Test
    @DisplayName("전진 조건 얻기 - 멈춤")
    void tryTest2() {
        int condition = 3;
        boolean result = car.isForward(condition);
        assertFalse(result);
    }

    @Test
    @DisplayName("전진 테스트")
    void forwardTest() {
        // given
        final int currentStatus = 3;
        Car car = new Car(currentStatus);
        final int expectedStatus = 4;

        // when
        car.forward();

        // then
        assertThat(expectedStatus).isEqualTo(car.getStatus());
    }

    // todo 통합 테스트
//    @Test
//    @DisplayName("멈춤 테스트")
//    void stopTest() {
//        // given
//        final int currentStatus = 3;
//        Car car = new Car(currentStatus);
//
//        // when
//
//        // then
//
//    }
}
