package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class WinnerTest {

  @Test
  void 단독_우승() {
    Names carNames = new Names("car1,car2,car3");
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.getCar(0).addScore(5);
    finalResult.getCar(1).addScore(3);
    finalResult.getCar(2).addScore(4);
    result.record(0, finalResult);

    Winner winner = new Winner(carNames, result);
    ArrayList<Car> winners = winner.getWinners();

    assertThat(winners).hasSize(1);
    assertThat(winners.get(0).getScore()).isEqualTo(5);
  }

  @Test
  void 일부_공동_우승() {
    Names carNames = new Names("car1,car2,car3");
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.getCar(0).addScore(5);
    finalResult.getCar(1).addScore(5);
    finalResult.getCar(2).addScore(3);
    result.record(0, finalResult);

    Winner winner = new Winner(carNames, result);
    ArrayList<Car> winners = winner.getWinners();

    assertThat(winners).hasSize(2);
    assertThat(winners.get(0).getScore()).isEqualTo(5);
    assertThat(winners.get(1).getScore()).isEqualTo(5);
  }

  @Test
  void 전체_공동_우승() {
    Names carNames = new Names("car1,car2,car3");
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.getCar(0).addScore(3);
    finalResult.getCar(1).addScore(3);
    finalResult.getCar(2).addScore(3);
    result.record(0, finalResult);

    Winner winner = new Winner(carNames, result);
    ArrayList<Car> winners = winner.getWinners();

    assertThat(winners).hasSize(3);
    assertThat(winners).allMatch(car -> car.getScore() == 3);
  }

  @Test
  void 아무도_전진하지_않은_경우() {
    Names carNames = new Names("car1,car2");
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.getCar(0).addScore(0);
    finalResult.getCar(1).addScore(0);
    result.record(0, finalResult);

    Winner winner = new Winner(carNames, result);
    ArrayList<Car> winners = winner.getWinners();

    assertThat(winners).hasSize(2);
    assertThat(winners).allMatch(car -> car.getScore() == 0);
  }
} 