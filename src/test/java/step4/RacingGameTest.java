package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.TestMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 테스트")
class RacingGameTest {

    private List<String> carNames = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));
    private RacingGame racingGame = new RacingGame(carNames, new TestMove());

    @DisplayName("play시 자동차 이동 확인")
    @Test
    void play() {
        Cars cars = racingGame.play();
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
    }

    @DisplayName("우승자 계산")
    @Test
    void calcWinner() {
        Cars cars = racingGame.play();
        cars.getCars().get(0).move();
        List<String> winnerNames = racingGame.calcWinner(cars);
        assertThat(winnerNames.get(0)).isEqualTo("c1");
    }
}
