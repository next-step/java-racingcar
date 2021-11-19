package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.cargameStrategy.CarRacingGameStrategy;
import step4.domain.cargameStrategy.RandomCarRacingGameStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {
    CarRacingGame carRacingGame;
    List<Car> carList;
    @BeforeEach
    void beforeEach() {
        Car pobiCar = new Car("pobi");
        Car crongCar = new Car("crong");
        Car honuxCar = new Car("honux");
        carList = Arrays.asList(pobiCar, crongCar, honuxCar);

        CarRacingGameStrategy randomGameStrategy = new RandomCarRacingGameStrategy();
        carRacingGame = new CarRacingGame(randomGameStrategy, carList, 3);
    }

    @Test
    @DisplayName("게임 마지막 라운드까지 진행했을 때, 가장 멀리 이동한 자동차가 우승한다.")
    void getWinner() {
        final int totalRound = 3;

        carRacingGame.play();
        List<String> carRacingGameWinners = carRacingGame.getWinner();

        assertThat(carRacingGameWinners).isEqualTo(finalRoundWinners(totalRound));
        assertThat(carRacingGameWinners.size()).isGreaterThan(0);
        assertThat(carRacingGameWinners.size()).isLessThan(carList.size());

    }

    private List<String> finalRoundWinners(int totalRound) {
        List<GameRound> gameResult = carRacingGame.getGameResult();
        GameRound finalRound = gameResult.get(totalRound - 1);
        return finalRound.getWinners();
    }

}