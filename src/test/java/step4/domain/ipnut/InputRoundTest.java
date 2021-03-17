package step4.domain.ipnut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputRoundTest {

    @DisplayName("InputRound 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int round = 5;

        // when
        InputRound inputRound = new InputRound(round);

        // then
        assertThat(inputRound).isNotNull();
    }
}