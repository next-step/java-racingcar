package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 테스트")
class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(3);
    }

    @Test
    @DisplayName("자동차 경주에 참여하는 자동차 대수 확인")
    void racingCarCheck() {
        assertThat(racing.getCars().size()).isEqualTo(3);
    }
}