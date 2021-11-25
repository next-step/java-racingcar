package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.cargameStrategy.RandomCarRacingGameStrategy;
import step5.domain.dto.CarData;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {
    CarRacingGame carRacingGame;
    List<Car> carList;

    @BeforeEach
    void beforeEach() {
        Cars cars = Cars.from("pobi,crong,honux");

        CarRacingGameStrategy randomGameStrategy = new RandomCarRacingGameStrategy();
        carRacingGame = new CarRacingGame(randomGameStrategy, cars, 3);
    }

    @Test
    @DisplayName("게임 마지막 라운드까지 진행했을 때, 가장 멀리 이동한 자동차가 우승한다.")
    void getWinner() {
        carRacingGame.play();
        List<String> carRacingGameWinners = carRacingGame.winners();

        assertThat(carRacingGameWinners).isEqualTo(finalRoundWinners());
        assertThat(carRacingGameWinners.size()).isGreaterThan(0);
        assertThat(carRacingGameWinners.size()).isLessThan(carList.size());

    }

    private List<String> finalRoundWinners() {
        GameHistory gameHistory = carRacingGame.getGameHistory();
        GameRound finalRound = gameHistory.finalRound();
        List<CarData> result = finalRound.getRoundResult();
        return Winners.decideWinner(result);
    }

}