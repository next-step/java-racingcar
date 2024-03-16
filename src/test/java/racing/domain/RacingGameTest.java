package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 게임을 진행하면 자동차가 위치가 이동된다")
    void move_postion() {
        Cars cars = Cars.create(new String[]{"pobi", "crong", "honux"});
        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        assertThat(cars.getCars().get(0).getPosition() > 1);
        assertThat(cars.getCars().get(1).getPosition() > 1);
    }

    @Test
    @DisplayName("우승자를 알려줄 수 있다")
    void find_winner() {
        Cars cars = Cars.create(new String[]{"pobi", "crong", "honux"});
        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        Winners winner = racingGame.findWinner();
        assertThat(winner.getWinners().size() > 1);
    }
}
