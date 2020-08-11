package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

  private String[] names;
  private RaceRule raceRule;

  @BeforeEach
  void setUp() {
    names = new String[]{"pobi", "crong", "honux"};
    raceRule = (d) -> d.cast() > 3;
  }

  @Test
  void given3Names_when1Race_then3Cars() {
    Cars cars = new Cars(names);

    List<Scorecard> scorecards = cars.race(raceRule, new Dice(0, 10));

    assertThat(scorecards.size())
        .isEqualTo(3);
  }

  @Test
  void givenForwardRule_OneRace_thenOneForwardAndAllWinners() {
    RaceRule raceRule = (d) -> true;
    Cars cars = new Cars(names);

    List<Scorecard> scorecards = cars.race(raceRule , new Dice(0, 10));

    for (Scorecard scorecard : scorecards) {
      assertThat(scorecard.getForwardCount())
          .isEqualTo(1);
    }

    assertThat(cars.podium().stream()
        .map(s -> s.getName())
        .collect(Collectors.toList()))
        .containsExactly(names);
  }

}