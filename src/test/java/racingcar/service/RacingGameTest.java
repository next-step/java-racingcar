package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Scoreboard;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void init() {
        racingGame = new RacingGame(new Racing());
    }

    @Test
    void placetForRacingTest(){

        //given
        List<String> list = new ArrayList<String>(Arrays.asList("pobi,maro","5"));

        //when
        Scoreboard board = racingGame.placetForRacingByName(list);

        //then
        assertThat(board.getCars().size()).isEqualTo(2);
        assertThat(board.getMove()).isEqualTo(5);
    }
    
}