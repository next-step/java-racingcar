package domain;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

  @Test
  void Winners_생성_성공() {
    final String CAR_NAME_1 = "name1";
    final String CAR_NAME_2 = "name2";
    final String CAR_NAME_3 = "name3";
    assertDoesNotThrow(() -> new Winners(List.of(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3)));
  }

  @Test
  void Winners_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Winners(emptyList()));
  }
}
