package racinggame.domain.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.TestRandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundsTest {

    @Test
    @DisplayName("getRoundCount 메서드가 게임 라운드 수를 반환한다.")
    void getRoundCountTest() {
        GameRounds gameRounds = initGameRounds();
        assertThat(gameRounds.getRoundCount()).isOne();
    }

    @Test
    @DisplayName("getCarPosition 메서드가 특정 라운드의 특정 자동차 위치를 반환한다.")
    void getCarPositionTest() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        Cars cars = new Cars(carNames);
        int correctMoveNumber = 5;
        cars.getCarList().get(0).move(new TestRandomNumber(correctMoveNumber));
        cars.getCarList().get(0).move(new TestRandomNumber(correctMoveNumber));
        GameResults gameResults = new GameResults(cars);
        GameRounds gameRounds = new GameRounds();
        gameRounds.save(gameResults);
        assertThat(gameRounds.getCarPosition(0, 0)).isEqualTo(2);
    }

    @Test
    @DisplayName("getCarName 메서드가 특정 라운드의 특정 자동차 이름을 반환한다.")
    void getCarNameTest() {
        GameRounds gameRounds = initGameRounds();
        assertThat(gameRounds.getCarName(0, 2)).isEqualTo("자동차3");
    }

    @Test
    @DisplayName("getWinner 메서드가 게임 우승자를 반환한다.")
    void getWinnerTest() {
        GameResults gameResults = initGameResults();
        gameResults.saveWinners(Car.create("자동차1"));
        GameRounds gameRounds = new GameRounds();
        gameRounds.save(gameResults);
        assertThat(gameRounds.getWinner()).isNotEmpty();
        assertThat(gameRounds.getWinner().get(0)).isEqualTo("자동차1");
    }

    private GameRounds initGameRounds() {
        GameRounds gameRounds = new GameRounds();
        gameRounds.save(initGameResults());
        return gameRounds;
    }

    private GameResults initGameResults() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        return new GameResults(new Cars(carNames));
    }

}