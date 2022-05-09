package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CarsTest {
    @Test
    void 포지션_문자로_출력() {
        assertThat(Cars.append(3)).isEqualTo("---");
    }
}
