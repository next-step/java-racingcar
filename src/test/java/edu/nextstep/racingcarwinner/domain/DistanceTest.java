package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @Test
    void create(){
        // given
        int distanceNum = 5;

        // when
        Distance distance = new Distance(distanceNum);

        // then
        assertThat(distance).isEqualTo(new Distance(5));
    }

    @Test
    void invalid() {
        // given
        int distanceNum = -1;

        // when, then
        assertThatThrownBy(() -> {
            new Distance(distanceNum);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        // given
        Distance distance = new Distance(5);

        // when
        distance = distance.move();

        // then
        assertThat(distance).isEqualTo(new Distance(6));
    }

}
