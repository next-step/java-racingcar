package study.racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
  @Test
  void 우승자_한명(){
    Car pobi = new Car("pobi", 2);
    Car conan = new Car("conan", 1);
    List<Car> cars = Arrays.asList(pobi, conan);

    List<Car> winners = Winners.findWinner(cars);

    assertThat(winners).hasSize(1);
    assertThat(winners).contains(pobi);
  }
}
