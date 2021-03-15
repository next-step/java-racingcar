package new_racingcar.domain;

import new_racingcar.service.GrandPrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("시도할 횟수 1 이상 테스트")
    public void roundCountTest(int roundCount) throws Exception {
        //given

        //when, then
        new Round(roundCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("시도할 횟수 0 이하 일 때 예외 테스트")
    public void roundCountExceptionTest(int roundCount) throws Exception {
        //given

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Round(roundCount);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1", "3,2"})
    @DisplayName("경기 라운드 진행 시 감소 테스트")
    public void rou(int roundCount, int checkRoundCount) throws Exception {
        //given
        Round beforeRound = new Round(roundCount);
        Round afterRound = new Round(checkRoundCount);

        //when
        beforeRound.isGameEnd();

        //then
        assertThat(beforeRound).isEqualTo(afterRound);
    }
}