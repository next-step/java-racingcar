package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상일 경우 1칸 전진한다.")
    void test1() {
        Car car = new Car("a");
        car.moveOrStopByRandomValue(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하일 경우 움직이지 않는다.")
    void test2() {
        Car car = new Car("a");
        car.moveOrStopByRandomValue(2);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
