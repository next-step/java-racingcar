package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Vector;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @DisplayName("차량 초기상태 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void testNumCars(int input) {

        List<Integer> results = new Vector<>(input);
        for (int i = 0; i < input; i++) {
            results.add(0);
        }

        assertThat(Cars.of(input).getPositions()).isEqualTo(results);

    }

}