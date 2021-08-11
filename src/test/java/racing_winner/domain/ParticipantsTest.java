package racing_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("입력한 자동차 수 만큼 생성됐는지 테스트")
    void getParticipantList() {
        String[] cars = new String[]{"pobi", "crong", "honux"};
        Participants participants = new Participants(cars);
        assertThat(participants.getParticipantList()).isEqualTo(3);
    }
}