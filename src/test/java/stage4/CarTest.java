package stage4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {
    private Car car;
    private String carName;

    @BeforeAll
    void setup() {
        carName = "name";
        car = new Car(carName);
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
    @DisplayName("forward - 전진 기능 테스트")
    void forwardTest() {
        // given
        final int currentStatus = 3;
        Car car = new Car(carName, currentStatus);
        final int expectedStatus = 4;

        // when
        car.forward();

        // then
        assertThat(expectedStatus).isEqualTo(car.getStatus());
    }
}
