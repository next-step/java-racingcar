package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("입력받은 횟수만큼 자동차들을 생성하는 Cars Test")
    @ValueSource(ints = {1, 2})
    void makeCarsTest(int input) {
        // when
        Cars cars = new Cars(input);

        // then
        assertThat(cars).hasSize(input);
    }
}
