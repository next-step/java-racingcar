package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import racingcar.Car;
import racingcar.RacingGame;

public class CarTest {
    @DisplayName("자동차는 이름을 입력받아 갖는다.")
    @ValueSource(strings = {"jason", "joy"})
    @ParameterizedTest
    public void name() {
        final Car car = new Car("jason", 10);
        assertThat(car.getName()).isEqualTo("jason");
    }

    @DisplayName("자동차 이름의 길이가 5글자 넘으면 예외발생한다.")
    @Test
    public void nameCheck() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("adfasdfasdf", 10));
    }

    @DisplayName("자동차의 초기 위치는 0이다.")
    @Test
    void positionInit() {
        final Car car = new Car("json");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    void current_position() {
        final Car car = new Car("json", 10);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @DisplayName("자동차가 4이상일 때 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void move(final int condition) {
        final Car car = new Car("json");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 4미만일 때 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void stop(final int condition) {
        final Car car = new Car("json");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }




}


