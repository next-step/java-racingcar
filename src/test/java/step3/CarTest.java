package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("차를 생성했을 때, 이름이 맞는지 테스트")
    void constructorTest() {
        Car car = new Car("붕붕이");

        assertThat(car.getName()).isEqualTo("붕붕이");
        assertThat(car.getTrace()).isEqualTo(0);
    }

    @Test
    @DisplayName("차가 전진했을 때, 전진한 정도가 맞는지 테스트")
    void plusTraceTest() {
        Car car = new Car("붕붕이");

        car.plusTrace();

        assertThat(car.getTrace()).isEqualTo(1);
    }
}
