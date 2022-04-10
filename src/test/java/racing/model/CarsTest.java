package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.GameResult.GameRoundResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차들은 이동후 GameRoundResult 를 반환한다")
    @Test
    void carMoveForward() {
        assertThat(new Cars(List.of(new Car(), new Car())).run(() -> true)).isInstanceOf(GameRoundResult.class);
    }
}