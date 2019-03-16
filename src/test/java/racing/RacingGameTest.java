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

        // 처음운행은 무조건 이동
        RacingGame rg = new RacingGame(1, carNames);
        for(Car car : rg.getList()){
            assertThat(car.getMovePosition()).isEqualTo(1);
        }

        rg = new RacingGame(5,carNames);
        //게임 처음 실행 및 라운드별 히스토리 기록
        GameRule gr = new CarGameRuleUseRandomNumber();
        rg.runRacingGame(gr);
        List<CarRoundResult> roundHistory = rg.getRoundHistory();

        // 라운드별 전체운행횟수 확인
        assertThat(roundHistory).hasSize(15);
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

        assertThat(winners).hasSize(3);
    }

    @Test
    public void 우승자한명테스트(){
        List<String> carNames = new ArrayList<String>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        RacingGame rg = new RacingGame(5, carNames);
        GameRule gameRule = new CarGameRuleOnlyTrue();
        rg.runRacingGame(gameRule);

    }
}