package study.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step5.domain.*;
import study.step5.dto.RacingGameResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameProgressTest {

    @ParameterizedTest
    @DisplayName("게임 구현에 대한(결과값) 테스트")
    @ValueSource(ints = {10, 25, 30})
    void gameStartTest(int tryNumber){
        String carNames ="차1,차2,차3";
        RacingGame racingGame = new RacingGame(carNames,tryNumber);
        RacingGameProgress racingGameProgress = new RacingGameProgress(racingGame);
        RacingGameResult racingGameResult = racingGameProgress.runGames(new RandomCarMoveCondition());

        assertThat(racingGameResult.getRounds()).hasSize(tryNumber);
    }

    @Test
    @DisplayName("게임 우승자 선정 테스트")
    void getChampionsTest(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("차1", 3));
        cars.add(new Car("차2", 4));
        cars.add(new Car("차3", 4));
        Round round = new Round(cars);

        assertThat(round.decideChampion()).containsExactly("차2","차3");
    }
}
