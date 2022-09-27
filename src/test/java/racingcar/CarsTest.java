package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void create() {
        String[] carNames = {"carA", "carB", "carC", "carD", "carE"};
        assertThat(new Cars(carNames).move(() -> true)).hasSize(5);
    }

}
