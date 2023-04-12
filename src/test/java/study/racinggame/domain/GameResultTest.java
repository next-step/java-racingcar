package study.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
  @Test
  @DisplayName("pobi가 가장 전진 많이한 경우 승자 확인 테스트")
  public void winners_승자_pobi() {
    Car pobiCar = new Car("pobi");
    Car onenyCar = new Car("oneny");
    Car twonyCar = new Car("twony");

    pobiCar.forward(() -> true);
    pobiCar.forward(() -> true);

    List<Car> carList = new ArrayList<>();

    carList.add(pobiCar);
    carList.add(onenyCar);
    carList.add(twonyCar);

    Cars cars = new Cars(carList);

    GameResult gameResult = new GameResult();
    gameResult.addRecord(cars);

    assertThat(gameResult.winners()).isEqualTo("pobi");
  }
}
