package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

  private Cars cars;

  @BeforeEach
  public void setUp() {
    List<Car> carList = new ArrayList<>();

    carList.add(new Car("toby"));
    carList.add(new Car("oneny"));
    carList.add(new Car("gary"));

    cars = new Cars(carList);
  }

  @Test
  public void play_3번_시도() {
    cars.forwardCars();
    cars.forwardCars();
    cars.forwardCars();

    assertThat(cars.cars().get(0).distance()).isBetween(0, 3);
  }
}
