package study.racingcar.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

  @DisplayName("입력받은 댓수의 차들은 입력받은 횟수 만큼 경기를 진행하며, 경기 한번 당 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void play_forwardOrStop_nameOfCarsAndNumOfRaces() {
    String[] names = new String[]{"a", "b", "c"};
    RacingGame racing = new RacingGame(names, 5);

    racing.start();
  }
}
