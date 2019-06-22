package com.java.jaeheon.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinnersTest {
    RacingGame racingGame;
    Car two;
    Car four;


    @BeforeEach
    void setup() {
        two = new Car(2, "two");
        four = new Car(2, "four");
        List<Car> cars = Arrays.asList(
                new Car(1, "one"),
                two,
                new Car(1, "three"),
                four);
        racingGame = new RacingGame(cars, 2);
    }

    @Test
    void findWinners() {
        assertThat(racingGame.getWinner()).containsExactly(two, four);
    }
}
