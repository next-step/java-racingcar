package racing_car.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    Random random;
    List<Car> cars;
    Car car;
    Race race;

    @BeforeEach
    void init() {
        random = new Random();
        race = new Race();
        cars = new ArrayList<>();
        car = new Car();
    }

    @Test
    @DisplayName("난수 생성 테스트")
    void 난수생성테스트() {
        for (int i = 0; i < 5; i++) {
            assertThat(race.generateRandomNumber()).isLessThan(10);
        }
    }

    @ParameterizedTest
    @DisplayName("random 값이 4이상일 때 전진하는 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 전진(int number) {
        for (int i=0; i<7; i++){
            Car car = new Car();
            Assertions.assertThat(number).isEqualTo(car.getDrivingDistance());
        }
    }

    @ParameterizedTest
    @DisplayName("Car 객체 생성 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 자동차객체생성(int number){
        List<Car> cars = Car.buildCarObject(number);
        Assertions.assertThat(cars.size()).isEqualTo(number);
    }

    @Test
    @DisplayName("자동차와 시도 회 수 입력 값이 0이하 일 때 예외 처리 하는 테스트")
    void 입력값테스트() {
        assertThatThrownBy(() ->
                Validation.inputValidation(0, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}