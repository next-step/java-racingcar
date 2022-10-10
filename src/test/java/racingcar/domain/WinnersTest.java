package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.condition.MoveCondition;
import racingcar.condition.RandomMoveCondition;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private MoveCondition moveCondition;

    @BeforeEach
    public void setUp() {
        this.moveCondition = new RandomMoveCondition();
    }
    @Test
    void find_winners() {
        List<Car> cars = Arrays.asList(
                new Car("유민", 3, moveCondition),
                new Car("두유", 2, moveCondition)
        );
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car("유민", 3, moveCondition));
    }
}
