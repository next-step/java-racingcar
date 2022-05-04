package racingcar.v2.domain;

import org.junit.jupiter.api.Test;
import racingcar.v2.domain.car.Participant;

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