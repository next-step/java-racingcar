package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {

  @Test
  void 단독_우승() {
    Names carNames = new Names(new String[]{"car1", "car2", "car3"});
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.at(0).addScore(5);
    finalResult.at(1).addScore(3);
    finalResult.at(2).addScore(4);
    result.record(0, finalResult);

    Winner winner = new Winner(result);

    List<Car> expected = List.of(
        new Car("car1", 5)
    );
    assertThat(winner.getWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }

  @Test
  void 일부_공동_우승() {
    Names carNames = new Names(new String[]{"car1", "car2", "car3"});
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.at(0).addScore(5);
    finalResult.at(1).addScore(5);
    finalResult.at(2).addScore(3);
    result.record(0, finalResult);

    Winner winner = new Winner(result);

    List<Car> expected = List.of(
        new Car("car1", 5),
        new Car("car2", 5)
    );
    assertThat(winner.getWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }

  @Test
  void 전체_공동_우승() {
    Names carNames = new Names(new String[]{"car1", "car2", "car3"});
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.at(0).addScore(3);
    finalResult.at(1).addScore(3);
    finalResult.at(2).addScore(3);
    result.record(0, finalResult);

    Winner winner = new Winner(result);

    List<Car> expected = List.of(
        new Car("car1", 3),
        new Car("car2", 3),
        new Car("car3", 3)
    );
    assertThat(winner.getWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }

  @Test
  void 아무도_전진하지_않은_경우() {
    Names carNames = new Names(new String[]{"car1", "car2"});
    Result result = new Result();

    Cars finalResult = new Cars(carNames);
    finalResult.at(0).addScore(0);
    finalResult.at(1).addScore(0);
    result.record(0, finalResult);

    Winner winner = new Winner(result);

    List<Car> expected = List.of(
        new Car("car1", 0),
        new Car("car2", 0)
    );
    assertThat(winner.getWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }
} 