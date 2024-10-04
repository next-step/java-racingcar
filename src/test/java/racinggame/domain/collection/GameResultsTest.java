package racinggame.domain.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.TestRandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    @Test
    @DisplayName("Cars 객체를 전달하여 GameResults 객체가 정상 생성된다.")
    void initTest() {
        GameResults gameResults = initGameResults();
        assertThat(gameResults).isNotNull();
    }

    @Test
    @DisplayName("carCount 메서드가 게임 결과에 저장된 게임 참여 자동차 대수를 반환한다.")
    void carCountTest() {
        GameResults gameResults = initGameResults();
        assertThat(gameResults.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("getGameResultCarPositionByIndex 메서드가 게임 결과에 저장된 자동차 위치를 반환한다.")
    void getGameResultCarPositionByIndexTest() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        Cars cars = new Cars(carNames);
        int correctMoveNumber = 5;
        cars.getCarList().get(0).move(new TestRandomNumber(correctMoveNumber));
        GameResults gameResults = new GameResults(cars);
        assertThat(gameResults.getGameResultCarPositionByIndex(0)).isOne();
        assertThat(gameResults.getGameResultCarPositionByIndex(1)).isZero();
        assertThat(gameResults.getGameResultCarPositionByIndex(2)).isZero();
    }

    @Test
    @DisplayName("getGameResultCarNameByIndex 메서드가 게임 결과에 저장된 자동차 이름을 반환한다.")
    void getGameResultCarNameByIndexTest() {
        GameResults gameResults = initGameResults();
        assertThat(gameResults.getGameResultCarNameByIndex(0)).isEqualTo("자동차1");
        assertThat(gameResults.getGameResultCarNameByIndex(1)).isEqualTo("자동차2");
        assertThat(gameResults.getGameResultCarNameByIndex(2)).isEqualTo("자동차3");
    }

    @Test
    @DisplayName("saveWinners 메서드가 외부에서 전달된 Car를 저장한다.")
    void saveWinnersTest() {
        GameResults gameResults = initGameResults();
        gameResults.saveWinners(Car.create("자동차1"));
        assertThat(gameResults.getWinners()).hasSize(1);
    }

    private GameResults initGameResults() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        return new GameResults(new Cars(carNames));
    }
}