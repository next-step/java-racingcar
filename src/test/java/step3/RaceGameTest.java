package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceGameTest {

  private RaceGame raceGame;

  @BeforeEach
  void setUp() {
    raceGame = new RaceGame();
  }

  @Test
  @DisplayName("init Test")
  public void initTest() {
    raceGame.init(1,3);
    assertThat(raceGame.race.carList.size()).isEqualTo(1);
    assertThat(raceGame.race.laps).isEqualTo(3);
  }

}
