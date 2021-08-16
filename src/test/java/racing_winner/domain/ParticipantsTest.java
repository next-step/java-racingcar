package racing_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("Participants 생성 테스트")
    void setParticipants() {
        String[] carNames = new String[]{"pobi", "crong"};

        assertThat(new Participants(carNames)).isNotNull();

    }
}