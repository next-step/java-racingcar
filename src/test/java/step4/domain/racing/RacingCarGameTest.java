package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {

    @DisplayName("RacingCarGame 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        InputNames inputNames = new InputNames("a,b,c");
        InputRound inputRound = new InputRound(5);

        // when
        RacingCarGame racingCarGame = new RacingCarGame(inputNames, inputRound);

        // then
        assertThat(racingCarGame).isNotNull();

    }
}