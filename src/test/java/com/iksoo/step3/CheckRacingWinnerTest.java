package com.iksoo.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckRacingWinnerTest {
    CheckRacingWinner checkRacingWinner;
    Car[] carsFirst, carsSecond;
    final int MAX_DISTANCE_FIRST = 3;
    final int MAX_DISTANCE_SECOND = 5;

    @BeforeEach
    void setUp() {
        checkRacingWinner = new CheckRacingWinner();

        carsFirst = new Car[3];
        carsFirst[0] = new Car("pobi");
        carsFirst[1] = new Car("crong");
        carsFirst[2] = new Car("honux");

        carsFirst[0].carPosition = "10101";
        carsFirst[1].carPosition = "00111";
        carsFirst[2].carPosition = "10001";

        carsFirst[0].currentDistance = 3;
        carsFirst[1].currentDistance = 3;
        carsFirst[2].currentDistance = 2;

        ////////

        carsSecond = new Car[4];
        carsSecond[0] = new Car("pobi");
        carsSecond[1] = new Car("crong");
        carsSecond[2] = new Car("honux");
        carsSecond[3] = new Car("Jinx");

        carsSecond[0].carPosition = "10000111";
        carsSecond[1].carPosition = "01110011";
        carsSecond[2].carPosition = "10000101";
        carsSecond[3].carPosition = "00000110";

        carsSecond[0].currentDistance = 4;
        carsSecond[1].currentDistance = 5;
        carsSecond[2].currentDistance = 3;
        carsSecond[3].currentDistance = 2;
    }

    @Test
    void checkResultTest() {
        assertThat(checkRacingWinner.checkResult(carsFirst)).contains("pobi","crong");
        assertThat(checkRacingWinner.checkResult(carsSecond)).contains("crong");
    }

    @Test
    void checkDistanceTest() {
        assertThat(checkRacingWinner.checkDistance(carsFirst)).isEqualTo(3);
        assertThat(checkRacingWinner.checkDistance(carsSecond)).isEqualTo(5);
    }

    @Test
    void checkCurrentPositionTest() {
        assertThat(checkRacingWinner.checkCurrentPosition(carsFirst[0])).isEqualTo(3);
        assertThat(checkRacingWinner.checkCurrentPosition(carsFirst[1])).isEqualTo(3);
        assertThat(checkRacingWinner.checkCurrentPosition(carsFirst[2])).isEqualTo(2);

        assertThat(checkRacingWinner.checkCurrentPosition(carsSecond[0])).isEqualTo(4);
        assertThat(checkRacingWinner.checkCurrentPosition(carsSecond[1])).isEqualTo(5);
        assertThat(checkRacingWinner.checkCurrentPosition(carsSecond[2])).isEqualTo(3);
        assertThat(checkRacingWinner.checkCurrentPosition(carsSecond[3])).isEqualTo(2);
    }
    
    @Test
    void addWinnerListTest() {
        List<Object> winner = new ArrayList<Object>();;
        assertThat(checkRacingWinner.addWinnerList(carsFirst[0], winner, MAX_DISTANCE_FIRST)).isTrue();
        assertThat(checkRacingWinner.addWinnerList(carsFirst[1], winner, MAX_DISTANCE_FIRST)).isTrue();
        assertThat(checkRacingWinner.addWinnerList(carsFirst[2], winner, MAX_DISTANCE_FIRST)).isFalse();

        assertThat(checkRacingWinner.addWinnerList(carsSecond[0], winner, MAX_DISTANCE_SECOND)).isFalse();
        assertThat(checkRacingWinner.addWinnerList(carsSecond[1], winner, MAX_DISTANCE_SECOND)).isTrue();
        assertThat(checkRacingWinner.addWinnerList(carsSecond[2], winner, MAX_DISTANCE_SECOND)).isFalse();
        assertThat(checkRacingWinner.addWinnerList(carsSecond[3], winner, MAX_DISTANCE_SECOND)).isFalse();
    }
}
