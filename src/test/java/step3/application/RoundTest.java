package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundTest {

    private static final int END_ROUND = 0;
    private static final int REMAINING_ROUNDS = 3;


    @DisplayName("남은 라운드가 잘 감소하는지 테스트")
    @Test
    void decrease() {
        //given
        Round round = new Round(REMAINING_ROUNDS);

        //when
        round.decrease();

        //then
        assertThat(round).isEqualTo(new Round(REMAINING_ROUNDS - 1));
    }

    @DisplayName("남은 라운드가 없을 때 라운드를 감소시키면 예외가 발생한다")
    @Test
    void decrease_withOutNextRound() {
        //given
        Round round = new Round(END_ROUND);

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(round::decrease)
                .withMessage("남은 라운드가 없습니다.");
    }

    @ParameterizedTest(name = "[{index}] remainingRounds: {0}, hasNext: {1}")
    @CsvSource(value = {
            "0, false",
            "1, true"
    })
    void hasNext(int remainingRounds, boolean hasNext) {
        Round round = new Round(remainingRounds);
        assertThat(round.hasNext()).isEqualTo(hasNext);
    }

}
