package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;
import racing.domain.RacingGameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("레이싱게임 클래스 테스트")
class RacingGameTest {

    @Test
    @DisplayName("carCount를 0으로 설정했을때 에러 테스트")
    void constructorCarCountValueIs0Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(0, 1));
    }

    @Test
    @DisplayName("round 수를 0으로 설정했을때 에러 테스트")
    void constructorRoundValueIs0Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(3, 0));
    }

    @Test
    @DisplayName("round 수를 GameResult로 검증하는 테스트")
    void roundCountTest() {
        int roundCount = 10;
        RacingGame racingGame = new RacingGame(3, roundCount);
        RacingGameResult gameResult = racingGame.playGame();
        List<List<Integer>> allRoundCarPositionList = gameResult.getAllRoundCarsPosition();

        assertThat(roundCount).isEqualTo(allRoundCarPositionList.size());
    }

    @Test
    @DisplayName("car count를 GameResult로 검증하는 테스트")
    void carCountTest() {
        int carCount = 9;
        RacingGame racingGame = new RacingGame(carCount, 4);
        RacingGameResult gameResult = racingGame.playGame();
        List<List<Integer>> allRoundCarPositionList = gameResult.getAllRoundCarsPosition();

        for (List<Integer> carList : allRoundCarPositionList) {
            int roundCarCount = carList.size();
            assertThat(carCount).isEqualTo(roundCarCount);
        }
    }
}