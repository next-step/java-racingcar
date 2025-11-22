package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundCountTest {
    @Test
    void create() {
        Assertions.assertThat(new RoundCount(1).value()).isEqualTo(1);
    }

    @Test
    void decrease() {
        Assertions.assertThat(new RoundCount(1).decrease()).isEqualTo(new RoundCount());
    }

    @Test
    void 라운드_수가_음수가_될수없음() {
        Assertions.assertThatThrownBy(()->new RoundCount(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 될 수 없습니다.");
    }
}
