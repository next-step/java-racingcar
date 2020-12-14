package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Scoreboard;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;


public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void init() {
        racingGame = new RacingGame(new Racing());
    }

    @Test
    void placetForRacingTest(){
        String[] racer = {"test","test1","test2"};
        int move = 5;
        //given

        //when
        Scoreboard board = racingGame.placetForRacingByName(racer, move);

        //then
        assertThat(board.getRacingCar().getCars().size()).isEqualTo(3);
        assertThat(board.getMove()).isEqualTo(5);
    }
    
}