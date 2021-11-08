package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarPositionTest {
    @Test
    @DisplayName("increasePosition 메소드는 position 값를 1 증가시킨다")
    public void 테스트_CarPosition_increasePosition() {

        CarPosition position = new CarPosition();
        position.increasePosition();
        assertThat(position.getPosition()).isEqualTo(1);
        position.increasePosition();
        assertThat(position.getPosition()).isEqualTo(2);
        position.increasePosition();
        assertThat(position.getPosition()).isEqualTo(3);
    }
}