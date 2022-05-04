package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    @DisplayName("3개의 자동차를 참가시키면 Cars의 크기는 3이된다.")
    void crateCarTest() {
        assertThat(new Cars("one,two,three").getCars()).hasSize(3);
    }
}
