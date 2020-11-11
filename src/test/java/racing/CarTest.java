package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;
import racing.model.RacingCars;
import racing.model.RacingCar;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차가 움직이지 않는 경우")
    void testCanNotMove(int input) {
        Car testCar = new RacingCar("tester");
        testCar.move(input);
        assertThat(testCar.currentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("자동차가 움직이는 경우")
    void testMove(int input) {
        Car testCar = new RacingCar("tester");
        int beforeMove = testCar.currentLocation();
        testCar.move(input);
        assertThat(testCar.currentLocation() - beforeMove).isEqualTo(1);
    }

    @Test
    @DisplayName("이름에 5자를 초과하는 값이 존재하는 경우 Exception 발생")
    void testNameCaseMorThenFive() {
        String input = "123456,1234";
        assertThatThrownBy(() -> new RacingCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 값 입력이 없는 경우")
    void testNameCaseNull() {
        String input = "";
        assertThatThrownBy(() -> new RacingCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 정상 분리")
    void testNameCaseSplit() {
        String input = "12345,1234,123,12,1";
        RacingCars cars = new RacingCars(input);
        assertThat(
                cars.getCandidates().stream()
                        .map(Car::getCarName).toArray()
        ).contains("12345", "1234", "123", "12", "1");
    }
}
