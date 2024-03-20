package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {
    @Test
    @DisplayName("참가자 이름 중복 테스트")
    void createParticipants_duplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.from("charmander,pikachu,charmander"))
                .withMessageMatching("중복된 이름이 존재합니다. 참가자 이름을 다시 확인해주세요.");
    }
}