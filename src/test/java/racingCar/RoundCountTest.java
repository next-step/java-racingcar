package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.RoundCount;

import static org.assertj.core.api.Assertions.*;

public class RoundCountTest {
    @Test
    void create() {
        assertThat(new RoundCount(1).value()).isEqualTo(1);
    }

    @Test
    void decrease() {
        assertThat(new RoundCount(1).decrease()).isEqualTo(new RoundCount());
    }

    @Test
    void 라운드_수가_음수가_될수없음() {
        assertThatThrownBy(()->new RoundCount(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 될 수 없습니다.");
    }
}
