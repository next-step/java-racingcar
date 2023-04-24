package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.factory.CarFactory;
import study.racingcar.factory.RaceFactory;
import study.racingcar.factory.RandomIntFactory;

public class RaceTest {

  @DisplayName("4미만의 RandomInt이 생성된다면, 모든 자동차는 움직이지 않는다.")
  @Test
  public void play_Stop() {
    String[] names = new String[]{"a", "b", "c"};
    Race race = new Race(CarFactory.createCars(names));

    race.play(new RandomIntFactory(0, 4));

    for (Car car : race.getCars()) {
      assertThat(car.isSamePosition(new Position(0)));
    }
  }

  @DisplayName("4이상의 RandomInt가 생성된다면, 모든 자동차는 움직인다.")
  @Test
  public void play_Forward() {
    String[] names = new String[]{"a", "b", "c"};
    Race race = new Race(CarFactory.createCars(names));

    race.play(new RandomIntFactory(4, 10));

    for (Car car : race.getCars()) {
      assertThat(car.isSamePosition(new Position(1)));
    }
  }

  @DisplayName("우승자가 한명이라면, 한개의 자동차만 반환한다.")
  @Test
  void findWinner_OneWinner() {
    Car pobi = new Car("pobi", 5);
    Car conan = new Car("conan", 1);
    List<Car> cars = Arrays.asList(pobi, conan);
    Race race = new Race(cars);

    List<Car> winners = race.findWinner();

    assertThat(winners).hasSize(1);
    assertThat(winners).contains(pobi);
  }

  @DisplayName("우승자가 두명이라면, 두개의 자동차를 반환한다.")
  @Test
  void findWinner_TwoWinners() {
    Car pobi = new Car("pobi", 2);
    Car conan = new Car("conan", 2);
    List<Car> cars = Arrays.asList(pobi, conan);
    Race race = new Race(cars);

    List<Car> winners = race.findWinner();

    assertThat(winners).hasSize(2);
    assertThat(winners).contains(pobi);
    assertThat(winners).contains(conan);
  }
}
