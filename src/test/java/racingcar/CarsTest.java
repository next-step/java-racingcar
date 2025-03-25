package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  void size() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    assertEquals(3, names.size());
  }

  @Test
  void at() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Cars cars = new Cars(names);
    assertEquals("car2", cars.at(1).getName());
  }
}
