package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.MovableStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    @DisplayName("자동차 레이싱 게임의 우승자는 여러명일 수 있다.")
    void getRacingWinners() {
        MovableStrategy movableStrategy = () -> true;
        RacingGame racingGame = new RacingGame(1, Arrays.asList("1", "2", "3"), movableStrategy);

        racingGame.move();

        assertEquals(3, racingGame.getWinners().size());
    }

    @ParameterizedTest
    @DisplayName("자동차 레이싱 게임 우승자 구하기")
    @MethodSource("getRacingCars")
    void validRacingWinner(List<Car> cars, Car winner) {
        RacingGame racingGame = new RacingGame(1, cars.toArray(new Car[0]));

        racingGame.move();

        assertEquals(1, racingGame.getWinners().size());
        assertEquals(winner.getName(), racingGame.getWinners().get(0).getName());
    }

    private static Stream<Arguments> getRacingCars() {
        Car car1 = new Car("1", () -> false);
        Car car2 = new Car("2", () -> false);
        Car car3 = new Car("3", () -> true);

        return Stream.of(Arguments.of(Arrays.asList(car1, car2, car3), car3));
    }

}