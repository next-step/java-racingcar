package racing;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void runRacingGame() {

        RacingGame racingGame = new RacingGame(5, Arrays.asList("car1", "car2", "car3"));
        GameRule gameRule = new CarGameRuleOnlyTrue();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        assertThat(racingGameResult.printRoundHistory()).hasSize(5);
        assertThat(racingGameResult.findRacingWinner()).hasSize(3);

        List<RacingGameRoundResult> racingGameRoundResults = racingGameResult.printRoundHistory();
        RacingGameRoundResult racingGameRoundResult = racingGameRoundResults.get(0);
        CarRoundResult carRoundResult = racingGameRoundResult.getCarResults().get(0);

        assertThat(carRoundResult.getMovePosition()).isEqualTo(5);
    }

    @Test
    public void 우승자테스트() {
        RacingGame racingGame = new RacingGame(5, Arrays.asList("car1", "car2", "car3"));

        //게임 처음 실행 및 라운드별 히스토리 기록
        GameRule gameRule = new CarGameRuleOnlyTrue();
        RacingGameResult gameResult = racingGame.runRacingGame(gameRule);

        List<String> winners = gameResult.findRacingWinner();
        assertThat(winners).hasSize(3);
    }

    @Test
    public void 우승자한명테스트() {
        RacingGame racingGame = new RacingGame(100, Arrays.asList("car1", "car2", "car3", "car4", "car5", "car6",
                "car7", "car8", "car9"));

        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult gameResult = racingGame.runRacingGame(gameRule);

        List<String> winners = gameResult.findRacingWinner();
        assertThat(winners).hasSize(1);
    }
}