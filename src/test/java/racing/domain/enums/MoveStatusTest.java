package racing.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoveStatusTest {
    @DisplayName("3단계 - 자동차 경주 - 자동차 전진 조건 테스트")
    @Test
    void go_condition() {
        int randomNumber = 4;
        assertThat(MoveStatus.findByNumber(randomNumber)).isEqualTo(MoveStatus.GO);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 멈춤 조건 테스트")
    @Test
    void stay_condition() {
        int randomNumber = 3;
        assertThat(MoveStatus.findByNumber(randomNumber)).isEqualTo(MoveStatus.STAY);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 움직임 조건 범위를 벗어나는 값을 입력하는 경우 RuntimeException 예외가 발생되는지 확인")
    @Test
    void pass_invalid_number_for_movable_condition() {
        int randomNumber = -1;
        assertThatThrownBy(() -> MoveStatus.findByNumber(randomNumber))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력한 숫자가 해당하는 범위의 code 가 없습니다.");
    }

}
