package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NamesTest {

  @Test
  void getNames() {
    String names = "car1,car2,car3";
    Names n = new Names(names);
    assertEquals(Arrays.asList("car1", "car2", "car3"), n.getNames());
  }

  @Test
  void size() {
    String names = "car1,car2,car3";
    Names n = new Names(names);
    assertEquals(3, n.size());
  }

  @Test
  void getCarName() {
    String names = "car1,car2,car3";
    Names n = new Names(names);
    assertEquals("car1", n.getCarName(0));
    assertEquals("car2", n.getCarName(1));
    assertEquals("car3", n.getCarName(2));
  }
}
