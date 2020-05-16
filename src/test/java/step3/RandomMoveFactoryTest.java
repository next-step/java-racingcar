package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.MoveStrategy;
import step3.domain.RandomMoveFactory;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveFactoryTest {

    @DisplayName("MoveStrategyFactory는 null을 반환하지 않으며 MoveStrategy Interface의 인스턴스이다.")
    @Test
    void getMoveTest() {
        IntStream.range(0, 100).forEach((i) -> {
            MoveStrategy moveStrategy = RandomMoveFactory.getInstance();

            assertThat(moveStrategy)
                    .isNotNull()
                    .isInstanceOf(MoveStrategy.class);
        });
    }
}

