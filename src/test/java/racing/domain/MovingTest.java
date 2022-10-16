package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovingTest {
    @Test
    void move_4이상() {
        Moving move = new Moving() {
          @Override
          protected int randomNumber() {
              return 4;
          }
        };
        assertThat(move.moveRandomNumber()).isEqualTo(1);
    }

    @Test
    void move_4미만() {
        Moving move = new Moving() {
            @Override
            protected int randomNumber() {
                return 3;
            }
        };
        assertThat(move.moveRandomNumber()).isEqualTo(0);
    }
}