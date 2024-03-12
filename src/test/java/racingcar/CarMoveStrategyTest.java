package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.domain.CarMoveStrategy;
import racingcar.mock.AlwaysMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveStrategyTest {

    @Nested
    class AlwaysMoveStrategyTest {

        private final int REPEAT_COUNT = 10;

        @RepeatedTest(REPEAT_COUNT)
        @DisplayName("[성공] 항상 이동하는 전략은 무조건 true 를 리턴한다.")
        void 성공_항상_이동하는_전략() {
            CarMoveStrategy moveStrategy = new AlwaysMoveStrategy();
            assertThat(moveStrategy.isMovable()).isTrue();
        }

    }

    @Nested
    class AlwaysStopStrategyTest {

        private final int REPEAT_COUNT = 5;

        @RepeatedTest(REPEAT_COUNT)
        @DisplayName("[성공] 항상 정지하는 전략은 무조건 false 를 리턴한다.")
        void 성공_항상_정지하는_전략() {
            CarMoveStrategy moveStrategy = new AlwaysMoveStrategy();
            assertThat(moveStrategy.isMovable()).isTrue();
        }

    }

}
