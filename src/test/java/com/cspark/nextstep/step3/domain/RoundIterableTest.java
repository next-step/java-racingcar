package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundIterableTest {

  @DisplayName("요청한 반복 횟수 만큼 Round가 생성")
  @Test
  void iterable() {
    String[] names = {"pobi", "crong", "honux"};
    Function<Dice, Boolean> rule = (d) -> d.cast() > 3;

    RoundIterable rounds = new RoundIterable(3, DriverUtil.makeDrivers(names, rule));

    assertThat(StreamSupport.stream(rounds.spliterator(), false)
        .count())
        .isEqualTo(3);

  }
}