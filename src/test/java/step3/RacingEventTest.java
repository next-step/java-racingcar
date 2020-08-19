package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingEventTest {

    private RacingEvent racingEvent = new RacingEvent(5, 3);

    @DisplayName("참여 car 수를 입력하면 입력한 만큼의 car가 생성되는지 테스트")
    @Test
    void readyEventTest(){
        assertThat(racingEvent.getCarList().size()).isEqualTo(5);
    }

}
