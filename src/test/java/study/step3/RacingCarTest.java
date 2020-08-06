package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.RacingCar;
import step3.domain.Car;
import step3.view.ResultView;

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
    void accelateTest(int motorRacingCount, String expected) {
        car = new Car(1);
        String mileAge = "";
        for (int i = 1; i <= motorRacingCount; i++) {
            mileAge += car.accelerate();
        }
        car.setMileAge(mileAge);
        assertThat(car.getMileAge()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 정지")
    @CsvSource(value = {"5:''", "3:''"}, delimiter = ':')
    void brakeTest(int motorRacingCount, String expected) {
        car = new Car(1);
        String mileAge = "";
        for (int i = 1; i <= motorRacingCount; i++) {
            mileAge += car.brake();
        }
        car.setMileAge(mileAge);
        assertThat(car.getMileAge()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("참여하는 자동차 대수 확인")
    @ValueSource(ints = 3)
    void preparedCarTest(int racingCarNumber) {
        Map<Integer, Car> carInfoMap = RacingCar.preparationForGame(racingCarNumber);
        assertThat(carInfoMap).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("레이싱 기능")
    @CsvSource(value = {"3:5", "2:7"}, delimiter = ':')
    void racingTest(int racingCarNumber, int motorRacingCount) {
        carInfoMap = RacingCar.preparationForGame(racingCarNumber);
        ResultView.carRace(carInfoMap, racingCarNumber, motorRacingCount);
    }


}
