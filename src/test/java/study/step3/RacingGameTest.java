package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step3.logic.RacingGame;

public class RacingGameTest {

  @DisplayName("입력받은 댓수의 차들은 입력받은 횟수 만큼 경기를 진행하며, 경기 한번 당 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void play_forwardOrStop_carList() {
    RacingGame racing = new RacingGame(new String[]{"a","b","c"}, 5);

    racing.start();
  }
}
