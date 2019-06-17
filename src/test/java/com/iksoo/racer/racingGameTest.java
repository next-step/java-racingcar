package com.iksoo.racer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class racingGameTest {

    RacingGame racingGame;

    private Set<Integer> numbers;
    private Set<Integer> numbersGoStop;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();

        racingGame.initiateObjects();

        numbers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        numbersGoStop = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            numbersGoStop.add(i);
        }
    }

    @Test
    void goOrStopTest() {
        assertThat(numbersGoStop.contains(racingGame.goOrStop())).isTrue();
    }

    @Test
    void getRandomTest() {
        assertThat(numbers.contains(racingGame.getRandom())).isTrue();
    }

}
