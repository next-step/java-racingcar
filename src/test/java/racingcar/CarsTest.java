package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  void size() {
    Names names = new Names("car1,car2,car3");
    assertEquals(3, names.size());
  }

  @Test
  void getCar() {
    Names names = new Names("car1,car2,car3");
    Cars cars = new Cars(names);
    assertEquals("car2", cars.getCar(1).getName());
  }
}
