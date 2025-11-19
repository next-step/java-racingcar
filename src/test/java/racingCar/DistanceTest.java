package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Distance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {

    @Test
    void 생성하면_처음_거리는_0() {
        Distance distance = new Distance();

        assertThat(distance.value()).isEqualTo(0);
    }

    @Test
    void 처음상태에서_plus_하면_거리가_1() {
        assertThat(new Distance().plus()).isEqualTo(new Distance(1));
    }

    @Test
    void 두개중_큰_객체를_반환() {
        Distance distance = new Distance();
        Distance greaterDistance = new Distance(2);

        assertThat(distance.greaterThan(greaterDistance)).isEqualTo(greaterDistance);
    }

    @Test
    void 음수_값을_허용하지_않음() {
        assertThatThrownBy(() -> new Distance(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수 값은 들어갈 수 없습니다.");
    }
}
