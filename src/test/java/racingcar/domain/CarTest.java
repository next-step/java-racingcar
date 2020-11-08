package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import racingcar.behavior.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Car 이름 유효성 검사 : 빈칸, 내용 없음")
    @ParameterizedTest
    @MethodSource("nullOrEmptyCarNameCase")
    void validNullOrEmptyCarName(boolean expect, String carName) {
        assertThat(Car.isNullOrEmpty(carName)).isEqualTo(expect);
    }

    private static Stream<Arguments> nullOrEmptyCarNameCase() {
        return Stream.of(
                Arguments.of(true, ""),
                Arguments.of(true, " "),
                Arguments.of(true, "\n"),
                Arguments.of(true, " \n "),
                Arguments.of(false, "peony")
        );
    }

    @DisplayName("Car 이름 유효성 검사 : 5자 초과")
    @ParameterizedTest
    @MethodSource("moreThanFiveCarNameCase")
    void validMoreThanFiveCarName(boolean expect, String carName) {
        assertThat(Car.isFiveLetterWords(carName)).isEqualTo(expect);
    }

    private static Stream<Arguments> moreThanFiveCarNameCase() {
        return Stream.of(
                Arguments.of(false, "peon"),
                Arguments.of(false, "peony"),
                Arguments.of(true, "peonyF")
        );
    }

    @DisplayName("Car 생성/전진 시 차 이름 확인")
    @ParameterizedTest
    @ValueSource(strings = "peony")
    void moveOrNotCarName(String carName) {
        Car car = new Car(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
        MovingStrategy movingStrategy = () -> true;
        car.move(movingStrategy);
        assertThat(car.getCarName()).isEqualTo(carName);
    }


    @DisplayName("Car 생성 시 distance 를 0으로 초기화 여부")
    @Test
    void createCar() {
        Car car = new Car("peony");
        assertThat(car.getPosition()).isZero();
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 이동 또는 정지 여부")
    @ParameterizedTest
    @MethodSource("moveCase")
    void moveOrStopCar(boolean moveOrNot, int distance, String carName) {
        Car car = new Car(carName);
        car.move(() -> moveOrNot);
        int result = car.getPosition();
        assertThat(result).isEqualTo(distance);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, 1, "peony"),
                Arguments.of(false, 0, "peony")
        );
    }
}