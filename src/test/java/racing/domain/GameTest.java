package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
  private final int CAR_CNT = 10;
  private final int TRY_CNT = 5;
  private Game game;

  @BeforeEach
  void init(){
    game = new Game(CAR_CNT, TRY_CNT);
  }

  @Test
  void gameContainsNCars(){
    assertThat(game.getCars().size()).isEqualTo(CAR_CNT);
  }

  @Test
  void gameContainsTryCnt(){
    assertThat(game.getTryCnt()).isEqualTo(TRY_CNT);
  }

  @Test
  void gamePlayTryCnt(){
    game.play();
    for(Car car : game.getCars()){
      assertThat(car.getPosition()).isBetween(0, TRY_CNT);
    }
  }
}
