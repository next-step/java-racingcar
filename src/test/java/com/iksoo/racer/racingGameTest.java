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

    Random random;

    @BeforeEach
    void setUp() {
        random = new Random();

        racingGame = new RacingGame();

        numbers = new HashSet<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
    }

    @Test
    void moveTest() {

    }

    @Test
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void isGoStopTest() {
        int randomValue = random.nextInt(10);

        assertThat(numbers.contains(randomValue)).isTrue();
    }

}
