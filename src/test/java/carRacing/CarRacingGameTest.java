package carRacing;


import carRacing.domain.Car;
import carRacing.domain.CarCompany;

import static carRacing.domain.Race.moveStatus;
import static carRacing.domain.RandomNumberGenerator.getRandomNumber;

import carRacing.domain.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void createCarObject() {
        int numberOfCar = 4;
        CarCompany carCompany = new CarCompany();
        assertThat(carCompany.createCar(numberOfCar).size()).isEqualTo(4);
    }

    @Test
    @DisplayName("랜덤값이 0~9 사이의 정수인지 테스트")
    void randomNumberGeneration() {
        assertThat(getRandomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 이동 실패 조건 테스트")
    void moveFailConditionTest(int value) {
        assertThat(moveStatus(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 이동 성공 조건 테스트")
    void moveSuccessConditionTest(int value) {
        assertThat(moveStatus(value)).isTrue();
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCarTest() {
        final int MOVE_DISTANCE = 1;
        Car car = new Car();
        Race.moveCar(car);
        assertThat(car.getLocation()).isEqualTo(MOVE_DISTANCE);
    }

}
