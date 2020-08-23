package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingEventTest {

    private RacingEvent racingEvent = new RacingEvent();

    @DisplayName("RacingEvent ready시 원하는 수만큼 car 생성 테스트")
    @Test
    void readyRacingEvent(){
        racingEvent.readyEvent(3);

        assertThat(racingEvent.getPositionHistory().size()).isEqualTo(3);
    }
}
