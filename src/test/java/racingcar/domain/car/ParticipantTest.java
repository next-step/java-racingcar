package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Participant("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant("hongs")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createTest() {
        Participant participant = new Participant("hong");
        assertThat(participant).isEqualTo(new Participant("hong"));
    }
}