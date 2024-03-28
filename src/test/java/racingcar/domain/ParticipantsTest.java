package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("전체 참가자 이름 미입력시 에러를 던진다.")
    void from_이름미입력(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.from(name))
                .withMessageMatching("전체 참가자 이름을 입력하세요.");
    }

    @Test
    @DisplayName("전체 참가자 이름 중복 테스트")
    void createParticipants_duplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.from("charmander,pikachu,charmander"))
                .withMessageMatching("중복된 이름이 존재합니다. 참가자 이름을 다시 확인해주세요.");
    }
}