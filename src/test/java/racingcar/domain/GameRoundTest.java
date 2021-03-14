package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRoundTest {

    @Test
    @DisplayName("게임 횟수 조건 0 이하 오류 검증 테스트")
    public void validateLessThanZero() throws Exception {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new GameRound(-10)).withMessage("0이하의 값인지 확인해주세요.");
        assertThatIllegalArgumentException().isThrownBy(() -> new GameRound(0)).withMessage("0이하의 값인지 확인해주세요.");
    }

    @Test
    @DisplayName("게임 횟수를 가져오는 로직을 테스트")
    public void getRound() throws Exception {
        //given
        int round = 5;
        GameRound gameRound = new GameRound(round);

        //when
        int getRound = gameRound.getRound();

        //then
        assertEquals(getRound, round, "입력한 숫자와 가져온 숫자는 일치해야 한다.");
    }
}