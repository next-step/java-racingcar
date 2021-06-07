package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    RacingGame racing;

    @BeforeEach
    void set() {
        racing = new RacingGame("1,2,3", 0);
    }

    @Test
    @DisplayName("이동 여부 테스트 코드 ")
    void dont_move() {
        Cars beforeState = racing.getCars();
        // return 값이 4 미만 이기 때문에 이동하지 않음
        racing.race(() -> 0);
        assertThat(beforeState.getCars().get(0).getMovingRange()).isEqualTo(racing.getCars().getCars().get(0).getMovingRange());
    }

    @Test
    @DisplayName("이동 여부 테스트 코드")
    void move() {
        Cars beforeState = racing.getCars();
        // return 값이 5 이상 이기 때문에 이동
        racing.race(() -> 5);
        assertThat(beforeState.getCars().get(0).getMovingRange()+1).isEqualTo(racing.getCars().getCars().get(0).getMovingRange());
    }
}
