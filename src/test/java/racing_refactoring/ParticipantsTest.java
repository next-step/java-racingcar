package racing_refactoring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_refactoring.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    @DisplayName(",으로 자동차 이름을 구분하여 참여할 자동차 객체를 생성한다")
    void setParticipants(){
        String[] carNames = new String[]{"pobi","crong","honux"};
        Participants participants = new Participants(carNames);

        assertThat(participants).isNotNull();
    }
    @Test
    @DisplayName("참여할 자동차 객체 생성 예외 테스트")
    void setParticipantsException(){

        Assertions.assertThatThrownBy(
                () -> new Participants(new String[]{""})
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
