package com.seok.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void start() {
        Racers racers = new Racers("foo,bar,baz");
        Trials trials = new Trials(3);
        assertThat(RacingGame.start(racers, trials)).isNotNull();
    }
}