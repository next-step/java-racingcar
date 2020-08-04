package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.RacingCar;
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

    @ParameterizedTest
    @DisplayName("참여하는 자동차 대수 확인")
    @ValueSource(ints = 3)
    void preparedCarTest(int racingCarNumber) {
        Map<Integer, Car> map = RacingCar.preparedCar(racingCarNumber);
        assertThat(map.size()).isEqualTo(3);
        assertThat(map).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("레이싱 기능")
    @CsvSource(value = {"1:5"}, delimiter = ':')
    void racingTest(int racingCarNumber, int gameCount) {
        carInfoMap = RacingCar.preparedCar(racingCarNumber);
        String carState = "";

        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = carInfoMap.get(i);
            if (car.getCarId() == i) {
                for (int j = 1; j <= gameCount; j++) {
                    int randomCondition = RacingCar.getAccelateNumber();
                    carState += RacingCar.racing(car, randomCondition);
                }
                car.setMileAge(carState);
                carInfoMap.put(car.getCarId(), car);
            }
        }
        System.out.println(carState);
    }


}
