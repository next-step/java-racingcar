package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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
    @ParameterizedTest
    @CsvSource({"true", "true", "true"})
    public void testIfCarHasMoved(boolean isMovable) {
        Car car = new Car(new RandomMovingStrategy());
        car.moveCarForward(isMovable);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차량이 움직이지 않는 테스트")
    @ParameterizedTest
    @CsvSource({"false", "false", "false"})
    public void testIfCarNeverMoved(boolean isMovable) {
        Car car = new Car(new RandomMovingStrategy());
        car.moveCarForward(isMovable);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
