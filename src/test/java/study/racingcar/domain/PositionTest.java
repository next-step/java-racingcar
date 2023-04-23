package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @DisplayName("위치 값이 0 미만인 위치는 생성할 수 없다.")
  @Test
  public void position_ThrowException_0미만() {
    assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("위치 값을 명시하지 않은 위치는 0을 갖는다.")
  @Test
  public void position_HasDefaultPosition() {
    assertThat(new Position().equals(new Position(0))).isTrue();
  }

  @DisplayName("위치 값을 증가시킨다.")
  @Test
  public void increase_plusNumber(){
    Position position = new Position();

    position.increase();
    assertThat(position.equals(new Position(1))).isTrue();
    position.increase();
    assertThat(position.equals(new Position(2))).isTrue();
    position.increase();
    assertThat(position.equals(new Position(3))).isTrue();
  }

  @DisplayName("위치 값이 같다면 Position은 동등하다.")
  @Test
  public void equals_equalsNumber_True(){
    Position position1 = new Position(10);
    Position position2 = new Position(10);
    Position otherPosition = new Position(11);

    assertThat(position1.equals(position2)).isTrue();
    assertThat(position1.equals(otherPosition)).isFalse();
    assertThat(position2.equals(otherPosition)).isFalse();
  }

  @DisplayName("최대 위치 값을 갖는 Postion을 반환한다.")
  @Test
  public void getMaxPosition(){
    Position position1 = new Position(10);
    Position position2 = new Position(11);
    Position position3 = new Position(12);

    assertThat(position1.getMaxPosition(position2).equals(position2)).isTrue();
    assertThat(position2.getMaxPosition(position3).equals(position3)).isTrue();
    assertThat(position1.getMaxPosition(position3).equals(position3)).isTrue();
  }
}
