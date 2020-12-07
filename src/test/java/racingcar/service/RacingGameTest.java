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
        String[] a = {"test","test1","test2"};
        String[] b ={"5"};
        //given
        Map<Integer, String[]> list = Map.of( 
                                                0 , a, 
                                               1 , b );

        //when
        Scoreboard board = racingGame.placetForRacingByName(list);

        //then
        assertThat(board.getRacingCar().getCars().size()).isEqualTo(3);
        assertThat(board.getMove()).isEqualTo(5);
    }
    
}