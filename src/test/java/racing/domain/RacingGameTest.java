package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RacingGameTest {
    @DisplayName("첫번째 자동차인 aaa가 움직이면 우승차는 aaa 1대, 움직이지 않으면 5대 공동 우승")
    @Test
    public void findWinnerTest() {
        //given
        MoveConditionStrategy moveConditionStrategy = new OverFourStrategy();
        List<Car> cars = Arrays.asList(new Car("aaa", moveConditionStrategy), new Car("bbb", moveConditionStrategy)
                , new Car("ccc", moveConditionStrategy), new Car("ddd", moveConditionStrategy), new Car("eee", moveConditionStrategy));

        RacingGame racingGame = new RacingGame(cars);
        boolean isMove = racingGame.getCars().get(0).isMove();

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        if (isMove) {
            assertAll(
                    () -> assertThat(winnerList.size()).isEqualTo(1),
                    () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
            );
        }
        if (!isMove) {
            assertAll(
                    () -> assertThat(winnerList.size()).isEqualTo(5),
                    () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
            );
        }
    }
}
