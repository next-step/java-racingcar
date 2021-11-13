package racinggame.domain.value;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.value.MoveResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.CAR4;
import static racinggame.fixture.CarFixture.CARS;

class MoveResultTest {

    @DisplayName("우승자 검증")
    @Test
    void findWinner() {
        MoveResult moveResult = new MoveResult(CARS);

        List<Car> winner = moveResult.findWinner();

        assertThat(winner).containsExactly(CAR4);
    }
}