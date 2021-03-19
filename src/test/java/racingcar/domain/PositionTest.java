package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  @DisplayName("Position이 제대로 잘 생성되는가")
  public void create() {
    //given
    //when
    Position position = new Position(3);

    //then
    assertEquals(position, new Position(3));

  }

  @Test
  @DisplayName("updatePosition() 을 통하여 위치 값이 변경되는지")
  public void move() {
    //given
    Position position = new Position(3);

    //when
    position.forwardPosition();

    //then
    assertEquals(position.toInt(), 4);
  }

  @Test
  @DisplayName("Position을 음수 값으로 생성하면 익셉션이 발생하는가")
  public void validateCreate() {
    //when
    //then
    //given
    assertThrows(IllegalArgumentException.class, () -> new Position(-1));
  }
}
