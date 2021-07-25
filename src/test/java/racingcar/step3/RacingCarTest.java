package racingcar.step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    @DisplayName("난수 생성 하기")
    void 난수생성하기(){
        for (int i=0; i< 10; i++){
            assertThat(RandomUtil.generateRandomNumber()).isBetween(0,9);
        }
    }

    @Test
    @DisplayName("Car 전진 테스트 ")
    void 자동차전진() {
        car.setDrivingDistance();
        Assertions.assertThat(car.getDrivingDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("Car 객체 생성 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 자동차객체생성(int number) {
        List<Car> cars = Car.buildCarObject(number);
        Assertions.assertThat(cars.size()).isEqualTo(number);
    }

    @Test
    @DisplayName("자동차 이동 거리 출력 테스트")
    void 자동차이동거리출력() {
        for (int i = 0; i < 5; i++) {
            car.setDrivingDistance();
        }
        String printResultContents = ResultView.printResultContents(car);
        Assertions.assertThat(printResultContents).isEqualTo("-----");

    }

    @Test
    @DisplayName("자동차와 시도 회 수 입력 값이 0이하 일 때 예외 처리 하는 테스트")
    void 입력값테스트() {
        assertThatThrownBy(() ->
                Validation.inputValidation(0, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}