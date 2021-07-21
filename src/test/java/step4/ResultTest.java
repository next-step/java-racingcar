package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.model.Cars;
import step4.game.Game;
import step4.model.PointOfCar;
import step4.move.BasicMoveStrategy;
import step4.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {"3:4:0", "5:5:1", "1:0:1", "7:8:0"}, delimiter = ':')
    @DisplayName("점수와 기준값이 주어졌을때 우승자인지 판단")
    public void checkWinner(int point, int max, int expected) {
        //given
        ResultView resultView = ResultView.of();
        PointOfCar pointOfCar = new PointOfCar("abc", point);

        //when
        resultView.checkWinner(pointOfCar, max);

        //then
        assertThat(resultView.getCountOfWinner()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:0", "a,b,c,d:0", "a:0"}, delimiter = ':')
    @DisplayName("게임이 실질적으로 시작되지 않은 경우 우승자는 없음")
    public void gameWithoutMove(String names, int expected) {
        //given
        Cars cars = Cars.of(names);
        Game game = new Game(0, cars);
        ResultView resultView = ResultView.of();

        //when
        resultView.setWinnerOfGame(game);

        //then
        assertThat(resultView.getCountOfWinner()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c", "a,b,c,d", "a"}, delimiter = ':')
    @DisplayName("게임 결과에 우승자가 적어도 한명 이상")
    public void runGame(String names) {
        //given
        Cars cars = Cars.of(names);
        Game game = new Game(10, cars);
        ResultView resultView = ResultView.of();
        int expected = 1;

        //when
        game.run(new BasicMoveStrategy());
        resultView.setWinnerOfGame(game);

        //then
        assertThat(resultView.getCountOfWinner()).isGreaterThanOrEqualTo(expected);
    }
}
