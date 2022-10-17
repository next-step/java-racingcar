package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingStrategyTest {

    @Test
    void random_4이상_움직인다() {
        MovingStrategy movingStrategy = new MovingStrategy();

        boolean isMovable = movingStrategy.isMovable(4);
        assertThat(isMovable).isTrue();
    }

    @Test
    void random_3이하_움직이지_않는다(){
        MovingStrategy movingStrategy = new MovingStrategy();

        boolean isMovable = movingStrategy.isMovable(3);
        assertThat(isMovable).isFalse();
    }
}
