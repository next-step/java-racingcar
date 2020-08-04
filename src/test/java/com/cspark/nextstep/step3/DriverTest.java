package com.cspark.nextstep.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DriverTest {

  private final int MIN = 0;
  private final int MAX = 9;
  private Dice falseDice;
  private Dice trueDice;
  private Driver driver;

  @BeforeEach
  void setUp() {
    this.falseDice = new Dice(MIN, 3);
    this.trueDice = new Dice(4, MAX);
    this.driver = new Driver("pcs", (d) -> d.cast() > 3);
  }

  @DisplayName("전진 할 수 있다.")
  @Test
  void driveForward() {
    assertThat(driver.drive(trueDice))
        .isOne();
  }

  @DisplayName("정지 할 수 있다.")
  @Test
  void driveStop() {
    assertThat(driver.drive(falseDice))
        .isZero();
  }
}