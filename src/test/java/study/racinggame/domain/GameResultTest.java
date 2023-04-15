package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

  private Car pobiCar;
  private Car onenyCar;
  private Car twonyCar;
  private Car crongCar;
  private GameResult gameResult;

  @BeforeEach
  public void setUp() {
    pobiCar = new Car("pobi");
    onenyCar = new Car("oneny");
    twonyCar = new Car("twony");
    crongCar = new Car("crong");
  }

  @Test
  @DisplayName("pobi, crong가 가장 전진 많이한 경우 승자 확인 테스트")
  public void winners_승자_pobi() {
    String expected1 = pobiCar.name();
    String expected2 = crongCar.name();

    pobiCar.forward(() -> true);
    crongCar.forward(() -> true);

    gameResult = new GameResult(new Cars(Arrays.asList(pobiCar, onenyCar, twonyCar, crongCar)));
    assertThat(gameResult.winners()).contains(expected1, expected2);
  }
}
