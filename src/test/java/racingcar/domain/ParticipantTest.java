package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("개인 참가자 이름 미입력시 예외를 던진다.")
    void from_이름미입력(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant(name))
                .withMessageMatching(Participant.MESSAGE_INPUT_PERSONAL_NAME);
    }

    @Test
    @DisplayName("개인 참가자 이름의 길이가 5를 초과하면 예외를 던진다.")
    void from_글자수제한() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant("CHARMANDER"))
                .withMessageMatching(Participant.MESSAGE_MAX_NAME_LENGTH);
    }
}