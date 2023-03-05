package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.Car;
import service.RacingCarService;
import view.RacingCarView;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCarService racingCarService = new RacingCarService();

    static Stream<Arguments> provideCarNamesAndTargetDistance() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", 5),
                Arguments.of("pobi", 5),
                Arguments.of("pobi,woni", 5));
    }

    @DisplayName("자동차 경주 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNamesAndTargetDistance")
    void startRacing(String input, int targetDistance) {
        List<String> carNames = RacingCarView.getCarObjects(input);

        racingCarService = new RacingCarService();
        racingCarService.startRacing(carNames, targetDistance);
    }

    @DisplayName("자동차 이름 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni, jun" })
    void getCarNamesTest(String input) {
        assertThat(RacingCarView.getCarObjects(input)).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("Car 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni, jun" })
    void getCarObjectsTest(String input) {
        List<String> carNames = RacingCarView.getCarObjects(input);
        List<Car> cars = racingCarService.makeCars(carNames);
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("랜덤 숫자 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    void getRandomNumberTest(int input) {
        Car car = new Car("pobi");
        assertThat(car.getRandomNumber()).isBetween(0, 9);
    }

    @DisplayName("자동차 이동거리 확인 테스트")
    @Test
    void moveForwardTest() {
        Car car = new Car("pobi");
        car.moveForward();
        car.moveForward();
        car.moveForward();
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @DisplayName("자동차 이동 불가 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void isMoveFalseTest(int input) {
        Car car = new Car("pobi");
        car.isMove(input);
        assertThat(car.isMove(input)).isFalse();
    }

    @DisplayName("자동차 이동 가능 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void isMoveTrueTest(int input) {
        Car car = new Car("pobi");
        car.isMove(input);
        assertThat(car.isMove(input)).isTrue();
    }

}
