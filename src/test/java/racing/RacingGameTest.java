package racing;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void runRacingGame() {
        List<String> carNames = new ArrayList<String>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        RacingGame rg = new RacingGame(5, carNames);
        //게임 처음 실행 및 라운드별 히스토리 기록
        GameRule gr = new CarGameRuleUseRandomNumber();
        rg.runRacingGame(gr);
        Map<Integer, Map<Car, Boolean>> roundHistory = rg.getRoundHistory();

        for (int i = 1; i < 5; i++) {
            Iterator<Car> iter = roundHistory.get(i).keySet().iterator();

            // 전체 라운드 5
            assertThat(roundHistory.size()).isEqualTo(5);
            // 라운드별 총 3대의 기록
            assertThat(roundHistory.get(i).size()).isEqualTo(3);

            while (iter.hasNext()) {
                Car car = iter.next();
                assertThat(car).isNotNull();
            }
        }
    }

    @Test
    public void 우승자테스트() {

        List<String> carNames = new ArrayList<String>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        RacingGame rg = new RacingGame(5, carNames);
        //게임 처음 실행 및 라운드별 히스토리 기록
        GameRule gameRule = new CarGameRuleOnlyTrue();
        rg.runRacingGame(gameRule);

        List<String> winners = new ArrayList<String>();
        winners = rg.winnerRacingGame();

        assertThat(winners.size()).isEqualTo(3);
    }

}