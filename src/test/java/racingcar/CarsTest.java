package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void create() {
        assertThat(new Cars(5).move(() -> true)).hasSize(5);
    }

}
