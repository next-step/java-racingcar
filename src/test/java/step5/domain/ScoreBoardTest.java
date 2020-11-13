package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.strategy.Movable;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-14.
 */
public class ScoreBoardTest {

    @ParameterizedTest
    @DisplayName("현재 라운드까지의 점수를 잘 갖고오는가")
    @ValueSource(ints = {2,3,4,5})
    public void is_scoreboards_history_until_this_round(int score) {
        // given
        Cars cars = Cars.of("a,b,c");

        // when
        for (Car car : cars.getCars()) {
            car.forward(score);
            cars.addRoundScore(car);
        }

        // then
        for (ScoreBoard scoreBoard : cars.getScoreBoards()) {
            assertThat(scoreBoard.getScoreHistory()).containsOnly(score);
        }
    }

}
