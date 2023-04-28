package lotto.step2.view;

import lotto.step2.domain.Lottos;
import lotto.step2.domain.TotalReturn;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static lotto.step2.enums.MatchNumber.getMatchStat;

public class ResultView {
    public static final String TEXT_WIN_STAT = "당첨 통계";
    public static final String TEXT_LINE = "---------";
    public static final String[] TEXT_RESULT = {"총 수익률은 ", "입니다.", "(기준이 1이기 때문에 결과적으로 손해라는 의미임)", "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"};
    public StringBuilder stringBuilder = new StringBuilder();

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(l -> System.out.println(l.getLotto()));
    }

    private List<String> getStatResult(Map<Integer, Long> statMap) {
        return statMap.entrySet().stream().map(entry -> (getMatchStat(entry.getKey())
                .map(match -> match.getMatchText() + entry.getValue() + "개"))
        ).flatMap(Optional::stream).collect(Collectors.toList());
    }

    public void printWinnerStat(Map<Integer, Long> statMap, TotalReturn result) {
        System.out.println(TEXT_WIN_STAT);
        System.out.println(TEXT_LINE);
        getStatResult(statMap).forEach(e -> stringBuilder.append(e).append("\n"));
        stringBuilder.append(TEXT_RESULT[0]).append(result.getTotalReturn()).append(TEXT_RESULT[1]);
        if (result.getTotalReturn() < 1) {
            stringBuilder.append(TEXT_RESULT[2]);
        } else {
            stringBuilder.append(TEXT_RESULT[3]);
        }
        System.out.println(stringBuilder);
    }
}
