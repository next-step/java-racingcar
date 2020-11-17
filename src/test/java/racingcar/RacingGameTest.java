package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RacingGameTest {
    RacingGame racingGame = new RacingGame();

    @Test
    void placetForRacingTest(){
        List<Integer> list =new ArrayList<Integer>(Arrays.asList(3,5));
        Scoreboard board = racingGame.placetForRacing(list);
        assertThat(board.getCars().size()).isEqualTo(3);
        assertThat(board.getMove()).isEqualTo(5);
    }
    
}