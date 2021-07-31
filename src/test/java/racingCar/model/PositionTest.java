package racingCar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("equals, hashCode 재정의 후 비교")
    @Test
    void 생성() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }

    @DisplayName("음수 값일 때 에러 발생")
    @Test
    void 생성_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1));
    }

    @Test
    void 이동() {
        assertThat(new Position().move()).isEqualTo(new Position(1));
    }
}