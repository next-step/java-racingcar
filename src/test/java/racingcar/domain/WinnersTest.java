package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winners;

class WinnersTest {

    @Test
    @DisplayName("우승자를 정상적으로 추려낸다")
    void from() {
        Winners winners = Winners.from(
            List.of(
                new Car("a", 1),
                new Car("b", 1),
                new Car("c", 0)
            )
        );
        assertThat(winners.names())
            .containsExactly("a", "b");
    }
}
