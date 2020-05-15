package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("차량 대수 Input만큼 Car 객체 배열을 생성받는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 8, 10})
    public void makeCarObjectsInAccordanceWithInput(int carCounts) {
        List<Car> cars = CarFactory.makeCars(carCounts);
        assertThat(cars.size()).isEqualTo(carCounts);
    }

    @DisplayName("차량이 움직이는지 확인하는 테스트")
    @Test
    public void testIfCarHasMoved() {
        Car car = new Car(new RandomMovingStrategy());
        car.moveCarPosition();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }
}
