package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @Test
    void 참가자를_생성한다() {
        //given
        Cars cars = Cars.join(Arrays.asList(Car.create("java")));
        //when
        Participant participant = Participant.join(cars);
        //then
        assertThat(participant).isNotNull();
    }

    @Test
    void 참가하는_자동차가_없으면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Participant.join(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
