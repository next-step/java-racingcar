package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DriverUtilTest {

  @DisplayName("드라이버 이름들 만큼 드라이버들를 만든다.")
  @Test
  void makeDrivers() {
    String[] names = {"pobi", "crong", "honux"};
    Function<Dice, Boolean> rule = (d) -> d.cast() > 3;

    assertThat(DriverUtil.makeDrivers(names, rule).stream()
        .map(driver -> driver.getName())
        .collect(Collectors.toList()))
        .containsExactlyInAnyOrder(names)
    ;
  }
}