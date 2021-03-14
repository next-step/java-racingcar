package dev.djoon.racingcar.domain.util;

public enum GameConstant {
  RANDOM_BOUNDARY(10),
  RANDOM_TEST_SEED(10),
  VALID_BOUNDARY(4);

  private final int value;

  GameConstant(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }
}
