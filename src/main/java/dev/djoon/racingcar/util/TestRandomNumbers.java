package dev.djoon.racingcar.util;

public class TestRandomNumbers extends RandomNumbers {

  @Override
  public int nextInt(int bound) {
    return GameConstant.VALID_BOUNDARY.value() + 1;
  }
}
