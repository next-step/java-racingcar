package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;
import racing.domain.RacingCars;
import racing.domain.RacingGameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("레이싱게임 클래스 테스트")
class RacingGameTest {

    @Test
    @DisplayName("carCount를 0으로 설정했을때 에러 테스트")
    void constructorCarCountValueIs0Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame("", 1));
    }

    @Test
    @DisplayName("round 수를 0으로 설정했을때 에러 테스트")
    void constructorRoundValueIs0Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame("test", 0));
    }

    @Test
    @DisplayName("round 수를 GameResult로 검증하는 테스트")
    void roundCountTest() {
        int roundCount = 10;
        RacingGame racingGame = new RacingGame("test", roundCount);
        RacingGameResult gameResult = racingGame.playGame();
        List<RacingCars> allRoundRacingCars = gameResult.getAllRoundRacingCars();

        assertThat(roundCount).isEqualTo(allRoundRacingCars.size());
    }

    @Test
    @DisplayName("car count를 GameResult로 검증하는 테스트")
    void carCountTest() {
        int carCount = 3;
        RacingGame racingGame = new RacingGame("test1,test2,test3", 4);
        RacingGameResult gameResult = racingGame.playGame();
        List<RacingCars> allRoundRacingCars = gameResult.getAllRoundRacingCars();

        for (RacingCars racingCars : allRoundRacingCars) {
            int oneRoundCarCount = racingCars.getCarList().size();
            assertThat(carCount).isEqualTo(oneRoundCarCount);
        }
    }
}