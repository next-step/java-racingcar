package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingEventTest {

    private RacingEvent racingEvent = new RacingEvent();

    @DisplayName("RacingEvent ready 시 원하는 수만큼 car 생성 테스트")
    @Test
    void readyRacingEvent(){
        String[] names = {"test1", "test2"};
        racingEvent.readyEvent(names);
        assertThat(racingEvent.getPositionHistory().size()).isEqualTo(2);
    }

    @DisplayName("우승자 1명 이상 선정 되는지 테스트")
    @Test
    void getWinnersNamesTest(){
        String[] names = {"test1", "test2"};
        racingEvent.readyEvent(names);
        racingEvent.startEvent(1);
        assertThat(racingEvent.getWinnersNames().size() > 0).isTrue();
    }
}
