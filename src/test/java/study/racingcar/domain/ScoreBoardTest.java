package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import study.racingcar.domain.car.Cars;
import study.racingcar.domain.round.Round;
import study.racingcar.domain.score.ScoreBoard;

public class ScoreBoardTest {

    @DisplayName("라운드 결과")
    @Test
    void a(){
        Round round = new Round(new Cars(Collections.emptyList()));
        ScoreBoard scoreBoard = new ScoreBoard();
    }
}
