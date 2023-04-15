package study.racinggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RacingGameTest {

  private Cars cars;

  @BeforeEach
  public void setUp() {
    cars = new Cars(new ArrayList<>(Arrays.asList(
            new Car("tobi"),
            new Car("oneny"),
            new Car("twony"))));
  }

  @Test
  public void play_3번_시도() {
    cars.forwardCars();
    cars.forwardCars();
    cars.forwardCars();

    assertAll(
            () -> assertThat(cars.cars().get(0).distance()).isBetween(0, 3),
            () -> assertThat(cars.cars().get(1).distance()).isBetween(0, 3),
            () -> assertThat(cars.cars().get(2).distance()).isBetween(0, 3)
    );
  }
}
