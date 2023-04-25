package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.step2.domain.Fixture.lottosList;
import static lotto.step2.domain.Fixture.winningNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 통계 결과(3개중 1개는 모두(6개) 일치, 나머지는 3개 일치)")
    void getWinnerStat() {
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        Lottos lottos = new Lottos(lottosList);

        assertThat(winningNumbers.getWinnerStat(lottos).get(6)).isEqualTo(1);
        assertThat(winningNumbers.getWinnerStat(lottos).get(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 번호를 입력 했을 때, 유효성 검증")
    void name() {
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        assertThat(winningNumbers.getWinningNumbers()).hasSize(6);
    }

    @ParameterizedTest
    @MethodSource("winningWrongNumber")
    @DisplayName("당첨 번호를 잘못 입력 했을 때, 유효성 검증(예외 throw)")
    void validateWinningNumber(List<Integer> list) {
        assertThatThrownBy(() -> new WinningNumbers(list)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> winningWrongNumber() {
        List<Integer> sevenList = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> overMinList = List.of(0, 1, 2, 3, 4, 5);
        List<Integer> overMaxList = List.of(1, 2, 3, 4, 5, 60);
        List<Integer> dupList = List.of(1, 1, 2, 3, 4, 5);

        return Stream.of(
                Arguments.arguments(sevenList),
                Arguments.arguments(overMinList),
                Arguments.arguments(overMaxList),
                Arguments.arguments(dupList)
        );
    }
}