package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiceTest {

  private final int MIN = 0;
  private final int MAX = 9;
  private Dice dice;

  @DisplayName("항상 MIN 값만 나온다.")
  @Test
  void castOnly_MIN() {
    this.dice = new Dice(MIN, 1);
    assertThat(dice.cast())
        .isEqualTo(MIN);
  }

  @DisplayName("항상 MAX 값만 나온다.")
  @Test
  void castOnly_MAX() {
    this.dice = new Dice(MAX, MAX + 1);
    assertThat(dice.cast())
        .isEqualTo(MAX);
  }
}