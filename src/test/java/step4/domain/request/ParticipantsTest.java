package step4.domain.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @DisplayName("객체가 생성되었울 때 주입되었던 리스트와 동일한지를 비교하는 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    @ValueSource(strings = {" ", "a,b,c", "우리박력탬은태민,꽃카리스마민호,샤이니만능열쇠키,두부온리다는온유"})
    void getParticipantsTest(String sentence) {
        // given
        String[] expected = sentence.split(",");

        // when
        Participants participants = Participants.from(expected);
        String[] actual = participants.getParticipants();

        // them
        assertThat(actual).isEqualTo(expected);
    }

}