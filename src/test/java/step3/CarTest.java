package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @RepeatedTest(10)
    @DisplayName("Car 의 run 수행 시 position 이 변하지 않거나, 1 만큼 증가하는지 테스트")
    public void carMoveTest() {
        Car car = new Car(0);
        car.run();
        assertThat(car.getPosition()).matches(position -> position == 1 || position == 2);
    }
}
