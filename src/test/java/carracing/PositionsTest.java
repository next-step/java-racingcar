package carracing;

import carracing.model.Positions;
import org.junit.jupiter.api.Test;

import static carracing.model.Positions.MOVED_ONCE;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionsTest {

  @Test
  public void moveTest() {
    Positions positions = new Positions();
    assertThat(positions.getFinalPosition()).isEqualTo(Positions.INITIAL_POSITION);
    positions.move(false);
    assertThat(positions.getFinalPosition()).isEqualTo(Positions.INITIAL_POSITION);
    positions.move(true);
    assertThat(positions.getFinalPosition()).isEqualTo(Positions.INITIAL_POSITION + MOVED_ONCE);
  }
}
