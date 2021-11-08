package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LapsTest {

    @DisplayName("자동차 경주의 바퀴 수가 생성되는지 확인")
    @Test
    void creteLaps() {
        Laps laps = new Laps(2);

        assertThat(laps).isNotNull();
    }

    @DisplayName("입력된 시도횟수와 생성된 시도횟수가 맞는지 확인")
    @Test
    void checkLapsCount() {
        int count = 5;
        Laps laps = new Laps(count);

        assertThat(laps.getCount()).isEqualTo(count);
    }
}
