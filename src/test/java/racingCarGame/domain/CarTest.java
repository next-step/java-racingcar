package racingCarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("AlwaysMoveStrategy 패턴은 항상 차를 움직인다.")
    void moveByAlwaysMoveStrategy() {
        assertThat(new AlwaysMoveStrategy().isCanMove()).isEqualTo(true);
    }

    @Test
    @DisplayName("NotMoveStrategy 패턴은 항상 차를 움직이지 않는다.")
    void moveByNotMoveStrategy() {
        assertThat(new NotMoveStrategy().isCanMove()).isEqualTo(false);
    }
}
