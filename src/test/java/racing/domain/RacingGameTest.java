package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RacingGameTest {
    @DisplayName("첫번째 자동차인 aaa가 움직이면 우승차는 aaa 1대")
    @Test
    public void findSingleWinnerTest() {
        //given
        List<Car> cars = Arrays.asList(
                new Car("aaa", () -> true),
                new Car("bbb", () -> false),
                new Car("ccc", () -> false),
                new Car("ddd", () -> false),
                new Car("eee", () -> false));

        RacingGame racingGame = new RacingGame(cars);

        racingGame.getCars().get(0).move();
        racingGame.getCars().get(1).move();
        racingGame.getCars().get(2).move();
        racingGame.getCars().get(3).move();
        racingGame.getCars().get(4).move();

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
                new Car("aaa", () -> true),
                new Car("bbb", () -> true),
                new Car("ccc", () -> true),
                new Car("ddd", () -> true),
                new Car("eee", () -> true));

        RacingGame racingGame = new RacingGame(cars);

        racingGame.getCars().get(0).move();
        racingGame.getCars().get(1).move();
        racingGame.getCars().get(2).move();
        racingGame.getCars().get(3).move();
        racingGame.getCars().get(4).move();

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        assertThat(winnerList.size()).isEqualTo(5);

    }
}
