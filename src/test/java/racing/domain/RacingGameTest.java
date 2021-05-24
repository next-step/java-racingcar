package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RacingGameTest {
    MoveConditionStrategy moveConditionStrategy;

    @BeforeEach
    public void beforeEach() {
        moveConditionStrategy = new OverFourStrategy();
    }

    @DisplayName("첫번째 자동차인 aaa가 움직이면 우승차는 aaa 1대")
    @Test
    public void findSingleWinnerTest() {
        //given
        List<Car> cars = Arrays.asList(
                new Car("aaa", moveConditionStrategy, 1),
                new Car("bbb", moveConditionStrategy, 0),
                new Car("ccc", moveConditionStrategy, 0),
                new Car("ddd", moveConditionStrategy, 0),
                new Car("eee", moveConditionStrategy, 0)
        );
        RacingGame racingGame = new RacingGame(cars);

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        assertAll(
                () -> assertThat(winnerList.size()).isEqualTo(1),
                () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
        );
    }

    @DisplayName("모든 자동차가 움직이면 전체 공동 우승")
    @Test
    public void findWholeWinnerTest() {
        //given
        List<Car> cars = Arrays.asList(
                new Car("aaa", moveConditionStrategy, 2),
                new Car("bbb", moveConditionStrategy, 2),
                new Car("ccc", moveConditionStrategy, 2),
                new Car("ddd", moveConditionStrategy, 2),
                new Car("eee", moveConditionStrategy, 2)
        );
        RacingGame racingGame = new RacingGame(cars);

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        assertThat(winnerList.size()).isEqualTo(5);
    }
}
