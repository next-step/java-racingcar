package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  void given3Names_whenRace_then3Cars() {
    String[] names = {"pobi", "crong", "honux"};
    Function<Dice, Boolean> rule = (d) -> d.cast() > 3;
    Dice dice = new Dice(0, 10);

    Cars cars = new Cars(1, names, rule);
    List<Scorecard> scorecards = null;
    while (cars.hasNextLap()) {
      scorecards = cars.race(dice);
    }

    assertThat(scorecards.size())
        .isEqualTo(3);
  }

  @Test
  void given3Round_whenRace_then3Records() {
    String[] names = {"pobi"};
    Function<Dice, Boolean> rule = (d) -> true;
    Dice dice = new Dice(0, 10);

    Cars cars = new Cars(3, names, rule);
    List<Scorecard> scorecards = null;
    while (cars.hasNextLap()) {
      scorecards = cars.race(dice);
    }

    for (Scorecard scorecard : scorecards) {
      assertThat(scorecard.getForwardCount())
          .isEqualTo(3);
    }
  }

  @Test
  void allWinners() {
    String[] names = {"pobi", "crong", "honux"};
    Function<Dice, Boolean> rule = (d) -> true;
    Dice dice = new Dice(0, 10);

    Cars cars = new Cars(1, names, rule);
    List<Scorecard> scorecards = null;
    while (cars.hasNextLap()) {
      scorecards = cars.race(dice);
    }

    assertThat(scorecards.stream()
        .map(s -> s.getName())
        .collect(Collectors.toList()))
        .containsExactly(names);
  }
}