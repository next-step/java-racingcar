package racinggame.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Count;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CountTest {

    @DisplayName("카운트 값이 0보다 큰 숫자 이외의 값이 들어왔을 경우 에러 처리 테스트")
    @Test
    void game_count_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Count(-1))
                .withMessage("시도할 회수는 0보다 큰 숫자여야 합니다.");
    }
}
