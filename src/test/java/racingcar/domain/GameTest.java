package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private MockCars cars;

    @BeforeEach()
    void setup() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 3));
            add(new Car("car2", 4));
            add(new Car("car3", 5));
        }};
        cars = new MockCars(carList, new TrueFalseRepeatChecker());
    }

    @DisplayName("다음 라운드가 남아있는지를 확인")
    @Test
    void hasNextRoundRemained() {
        Game game = new Game(cars, 1);

        assertThat(game.hasNextRound()).isEqualTo(true);
    }

    @DisplayName("다음 라운드가 남아있는지 않은지를 확인")
    @Test
    void hasNextRoundNotRemained() {
        Game game = new Game(cars, 0);

        assertThat(game.hasNextRound()).isEqualTo(false);
    }

    @DisplayName("라운드 진행 후 현재 라운드를 잘 가져오는지 확인")
    @Test
    void nextRound() {
        Game game = new Game(cars, 1);

        ResultRound resultRound = game.nextRound();

        assertThat(cars.playCnt).isEqualTo(1);
        assertThat(game.hasNextRound()).isEqualTo(false);
        assertThat(resultRound).isEqualTo(cars.getRound());
    }

    @DisplayName("승리 결과를 잘 가져오는지 확인")
    @Test
    void getResultWinners() {
        Game game = new Game(cars, 0);

        ResultWinners resultWinners = game.computeWinner();

        assertThat(resultWinners).isEqualTo(cars.getWinners());
    }
}
