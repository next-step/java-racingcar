package com.cspark.nextstep.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  private final int MIN = 0;
  private final int MAX = 9;
  private Dice falseDice;
  private Dice trueDice;
  private Car car;

  @BeforeEach
  void setUp() {
    this.falseDice = new Dice(MIN, 3);
    this.trueDice = new Dice(4, MAX);
    this.car = new Car("pcs");
  }

  @DisplayName("전진 할 수 있다.")
  @Test
  void driveForward() {
    car.drive(() -> true);
    assertThat(car.forwardCount())
        .isOne();
  }

  @DisplayName("정지 할 수 있다.")
  @Test
  void driveStop() {
    car.drive(() -> false);
    assertThat(car.forwardCount())
        .isZero();
  }
}