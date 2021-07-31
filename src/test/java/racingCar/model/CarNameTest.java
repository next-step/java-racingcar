package racingCar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @DisplayName("equals, hashCode 재정의 후 비교")
    @Test
    void 생성() {
        CarName carName = new CarName("pobi");
        assertThat(carName).isEqualTo(new CarName("pobi"));
    }

    @DisplayName("음수 값일 때 에러 발생")
    @Test
    void 생성_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("carName"));
    }
}