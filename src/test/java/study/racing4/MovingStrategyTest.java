package study.racing4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MovingStrategyTest {

    @Test
    @DisplayName("움직일 수 있는 경우 확인")
    public void 움직일_수_있는_경우_확인() {

        MovingStrategy moveAble = new MovingStrategy() {
            @Override
            public boolean moveable() {
                return true;
            }
        };

        assertThat(moveAble.moveable()).isEqualTo(true);
    }

    @Test
    @DisplayName("움직일 수 없는 경우 확인")
    public void 움직일_수_없는_경우_확인() {

        MovingStrategy moveAble = new MovingStrategy() {
            @Override
            public boolean moveable() {
                return false;
            }
        };

        assertThat(moveAble.moveable()).isEqualTo(false);
    }
}
