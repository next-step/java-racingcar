package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.dto.MoveResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void move_메서드는_주어진_전략에_따라_Car들을_전진시킨_후_MoveLog를_반환합니다() {
        int carCount = 5;
        MoveStrategy fakeAbsoluteMoveStrategy = Position::moveOneStep;
        Cars cars = new Cars(carCount, fakeAbsoluteMoveStrategy);

        MoveResult expected = new MoveResult(
                Arrays.asList(true, true, true, true, true)
        );

        MoveResult moveResult = cars.move();

        assertThat(moveResult).isEqualTo(expected);
    }

}
