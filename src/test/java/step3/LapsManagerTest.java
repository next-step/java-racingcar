package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LapsManagerTest {

    @Test
    @DisplayName("마지막 횟수인지 논리값을 정상적으로 반환한다.")
    public void booleanTest() {
        LapsManager lapsManager = new LapsManager(new Count(0));

        assertThat(lapsManager.isLastLap()).isTrue();
    }

    @Test
    @DisplayName("내부적으로 횟수를 정상적으로 차감한다.")
    public void minusTest() {
        LapsManager lapsManager = new LapsManager(new Count(1));

        lapsManager.finishLap();

        assertThat(lapsManager.isLastLap()).isTrue();
    }
}