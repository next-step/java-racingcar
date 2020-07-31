package camp.nextstep.edu.rebellion.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    @DisplayName("자동차 경주 게임이 잘 수행 되는지 확인")
    @Test
    public void startTest() {
        // given
        int carNumbers = 3;
        int rounds = 5;
        RacingGameStub racingGameStub = new RacingGameStub(carNumbers, rounds);
        String expectedLane1 = "-\n-\n-";
        String expectedLane2 = "--\n--\n--";
        String expectedLane3 = "---\n---\n---";
        String expectedLane4 = "----\n----\n----";
        String expectedLane5 = "-----\n-----\n-----";

        // when
        Record record = racingGameStub.start();

        // then
        assertAll(
                () -> assertThat(record.getRecordLane()).hasSize(rounds),
                () -> assertThat(record.getRecordLane()).contains(expectedLane1),
                () -> assertThat(record.getRecordLane()).contains(expectedLane2),
                () -> assertThat(record.getRecordLane()).contains(expectedLane3),
                () -> assertThat(record.getRecordLane()).contains(expectedLane4),
                () -> assertThat(record.getRecordLane()).contains(expectedLane5)
        );
    }
}
