package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.NumberGenerator;
import racing.domain.Racing;
import racing.domain.RandomNumberGenerator;
import racing.dto.RoundResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
public class RacingTest {

    @Test
    void 자동차_경주는_이동횟수만큼_진행() {
        String names = "one,two,three";
        int totalRound = 5;
        Racing racing = new Racing(names, totalRound, new RandomNumberGenerator());
        for (int idx = 0; idx < totalRound; idx++) {
            assertThat(racing.isEnd()).isEqualTo(false);
            racing.play();
        }
        assertThat(racing.isEnd()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void 이동횟수_10이하의_자연수가_아니라면_오류_발생(int round) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Racing("one,two", round, new RandomNumberGenerator()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 이동횟수_10이하의_자연수라면_오류_미발생(int round) {
        assertDoesNotThrow(() -> new Racing("one,two", round, new RandomNumberGenerator()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 모두_동일하게_움직일_경우_라운드의_결과_검증(int round) {
        Racing racing = new Racing("one,two", round, () -> 5);

        for (int i = 1; i <= round; i++) {
            racing.play();
            RoundResult roundResult = racing.getRoundResult();
            assertThat(roundResult.getCars().size()).isEqualTo(2);
            assertThat(roundResult.getCars().get(0).getPosition()).isEqualTo(i);
        }

        RoundResult finalRoundResult = racing.getRoundResult();
        assertThat(finalRoundResult.getWinners().size()).isEqualTo(2);
        assertThat(finalRoundResult.getWinners().get(0)).isEqualTo("one");
        assertThat(finalRoundResult.getWinners().get(1)).isEqualTo("two");
    }

    @Test
    void 서로_다르게_움직일_경우_라운드의_결과_검증() {
        Racing racing = new Racing("one,two", 1, new NumberGenerator() {

            private int[] randomNumbers = new int[]{1, 4};
            private int index = 0;

            // 1, 4를 번갈아 반환한다.
            @Override
            public int generate() {
                return randomNumbers[index++%2];
            }
        });

        racing.play();
        RoundResult roundResult = racing.getRoundResult();
        assertThat(roundResult.getCars().size()).isEqualTo(2);

        assertThat(roundResult.getCars().get(0).getName()).isEqualTo("one");
        assertThat(roundResult.getCars().get(0).getPosition()).isEqualTo(0);

        assertThat(roundResult.getCars().get(1).getName()).isEqualTo("two");
        assertThat(roundResult.getCars().get(1).getPosition()).isEqualTo(1);

        assertThat(roundResult.getWinners().get(0)).isEqualTo("two");
    }


}
