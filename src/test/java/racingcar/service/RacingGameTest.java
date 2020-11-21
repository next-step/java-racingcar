package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Scoreboard;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void init() {
        racingGame = new RacingGame(new Racing(), new ResultView());
    }

    @Test
    void placetForRacingTest(){

        //given
        List<Integer> list =new ArrayList<Integer>(Arrays.asList(3,5));

        //when
        Scoreboard board = racingGame.placetForRacing(list);

        //then
        assertThat(board.getCars().size()).isEqualTo(3);
        assertThat(board.getMove()).isEqualTo(5);
    }
    
}