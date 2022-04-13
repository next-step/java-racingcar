package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;
import racing.dto.GameResult.GameRoundResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차들은 이동후 GameRoundResult 를 반환한다")
    @Test
    void carMoveForward() {
        List<String> names = List.of("carA", "carB", "carAB");
        Cars cars = new Cars(names);

        assertThat(cars.run(() -> true)).isInstanceOf(GameRoundResult.class);
    }
}