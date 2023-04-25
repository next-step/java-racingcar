package lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = validateWinningNumbers(winningNumbers);
    }

    private List<Integer> validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개만 가능합니다.");
        }
        if (Collections.max(winningNumbers) > 45 || Collections.min(winningNumbers) < 1) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45까지만 가능합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
        return winningNumbers;
    }

    public Map<Integer, Long> getWinnerStat(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.stream().filter(winningNumbers::contains).collect(Collectors.toList()))
                .collect(Collectors.groupingBy(List::size, Collectors.counting()));
    }
}
