package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    @DisplayName("위치는 음수값을 가질 수 없으므로 예외를 던진다.")
    public void validate_Negative_ThrowException() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션에서 한 칸 이동이 가능하다.")
    public void moveForth_moveOnePosition_moveAlright() {
        Position nowPosition = new Position(0);
        nowPosition.moveForth();

        assertThat(nowPosition.isSameDistance(1)).isTrue();
    }

    @Test
    @DisplayName("본인보다 더 먼 값을 선택할 수 있다.")
    public void chooseRemoteDistance_ChooseBetweenNearAndRemotePosition_CanChooseRemotePosition() {
        Position nearPosition = new Position(4);
        int selectedPosition = nearPosition.chooseRemoteDistance(5);

        assertThat(selectedPosition).isEqualTo(5);
    }
}
