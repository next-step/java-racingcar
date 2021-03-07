package dev.djoon.racingcar.util;

public enum GameConstant {
  RANDOM_BOUNDARY(10),
  VALID_BOUNDARY(4);

  private final int value;

  GameConstant(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }
}
