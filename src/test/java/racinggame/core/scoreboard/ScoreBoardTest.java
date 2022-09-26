package racinggame.core.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.core.car.Car;
import racinggame.core.car.Cars;
import racinggame.exception.InvalidRoundException;

class ScoreBoardTest {

    private static final int ENOUGH_FUEL = 9;
    private static final int NOT_ENOUGH_FUEL = 1;
    private static final int ROUND = 1;

    @Test
    @DisplayName("특정 라운드 전체 기록 확인.")
    void get_scores_of_round() {
        ScoreBoard scoreBoard = getDefaultNewScoreBoard();
        Score score = scoreBoard.getScore(ROUND);

        assertAll(
                () -> assertThat(score.getScore("A")).isEqualTo(1),
                () -> assertThat(score.getScore("B")).isEqualTo(0),
                () -> assertThat(score.getScore("C")).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("특정 라운드 우승자 확인.")
    void get_winner_of_round() {
        ScoreBoard scoreBoard = getDefaultNewScoreBoard();
        List<String> winners = scoreBoard.getWinner(ROUND);

        assertAll(
                () -> assertThat(winners).contains("A"),
                () -> assertThat(winners).doesNotContain("B"),
                () -> assertThat(winners).contains("C")
        );
    }

    @Test
    @DisplayName("존재하지 않는 라운드 확인 시 예외 발생.")
    void fail_get_invalid_round_score() {
        ScoreBoard scoreBoard = getDefaultNewScoreBoard();
        assertThatThrownBy(() -> scoreBoard.getWinner(-1))
                .isInstanceOf(InvalidRoundException.class);
    }

    private ScoreBoard getDefaultNewScoreBoard() {
        List<Car> carList = List.of(new Car("A"), new Car("B"), new Car("C"));

        carList.get(0).move(ENOUGH_FUEL);
        carList.get(1).move(NOT_ENOUGH_FUEL);
        carList.get(2).move(ENOUGH_FUEL);

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(new Cars(carList));

        return scoreBoard;
    }

}