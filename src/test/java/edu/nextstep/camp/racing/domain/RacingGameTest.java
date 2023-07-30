package edu.nextstep.camp.racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 례이싱_게임_시작_테스트(){
        RacingGame racingGame = new RacingGame();

        List<RacingResult> racingResults = racingGame.startGame(new Cars("test","test2","test3"), 5);

        assertThat(racingResults).size().isEqualTo(5);
    }
}
