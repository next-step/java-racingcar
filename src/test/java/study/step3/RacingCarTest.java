package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private Car car;
    private Map<Integer, Car> carInfoMap;

    @BeforeEach
    void setUp() {
        carInfoMap = new HashMap<>();
    }

    @ParameterizedTest
    @DisplayName("자동차 전진")
    @CsvSource(value = {"5:-----", "3:---"}, delimiter = ':')
    void accelateTest(int gameCount, String result) {
        car = new Car(1);
        String carState = "";
        for (int i = 1; i <= gameCount; i++) {
            carState += car.accelerate();
        }
        car.setMileAge(carState);
        carInfoMap.put(car.getCarId(), car);
        assertThat(car.getMileAge()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("자동차 정지")
    @CsvSource(value = {"5:''", "3:''"}, delimiter = ':')
    void brakeTest(int gameCount, String result) {
        car = new Car(1);
        String carState = "";
        for (int i = 1; i <= gameCount; i++) {
            carState += car.brake();
        }
        car.setMileAge(carState);
        carInfoMap.put(car.getCarId(), car);
        assertThat(car.getMileAge()).isEqualTo(result);
    }


}
