package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NamesTest {

  @Test
  void getNamesByIndex() {
    Names n = new Names(new String[]{"car1", "car2", "car3"});
    assertEquals(Arrays.asList("car1", "car2", "car3"), n.getNames());
  }

  @Test
  void validate() {
    assertThrows(IllegalArgumentException.class,
        () -> new Names(new String[]{"car1", "car2", "car12345"}));
    assertThrows(IllegalArgumentException.class, () -> new Names(new String[]{"car1", "car2", "car12345"}));
  }

  @Test
  void size() {
    Names n = new Names(new String[]{"car1", "car2", "car3"});
    assertEquals(3, n.size());
  }

  @Test
  void getNameByIndex() {
    Names n = new Names(new String[]{"car1", "car2", "car3"});
    assertEquals("car1", n.getNameByIndex(0));
    assertEquals("car2", n.getNameByIndex(1));
    assertEquals("car3", n.getNameByIndex(2));
  }
}
