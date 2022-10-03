package racingCar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.strategy.TestMovingStrategy;
import racingcar.domain.RacingRule;
import racingcar.domain.ScoreBoards;
import racingcar.strategy.MovingStrategy;

public class RacingRuleTest {

  @Test
  @DisplayName("이름 3명 입력 시 정상적으로 리스트 생성")
  void testBuildCars() {
    RacingRule racingRule = new RacingRule("son,cha,park", 3);
    assertThat(racingRule.getCars().get(0).getName()).isEqualTo("son");
    assertThat(racingRule.getCars().get(1).getName()).isEqualTo("cha");
    assertThat(racingRule.getCars().get(2).getName()).isEqualTo("park");

  }

  @Test
  @DisplayName("시도 횟수 3회 시 이름, 스코어보드 길이 동일")
  void try3Times() {
    RacingRule racingRule = new RacingRule("son,cha,park", 3);
    MovingStrategy movingStrategy = new TestMovingStrategy();
    racingRule.play(movingStrategy);
    List<ScoreBoards> scoreBoards = racingRule.getScoreBoardsList();
    assertThat(racingRule.getCars().size()).isEqualTo(scoreBoards.size());
  }
}
