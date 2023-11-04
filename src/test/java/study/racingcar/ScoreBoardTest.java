package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ScoreBoardTest {

    @DisplayName("라운드 결과")
    @Test
    void a(){
        Round round = new Round(new Cars(Collections.emptyList()));
        ScoreBoard scoreBoard = new ScoreBoard();
    }
}
