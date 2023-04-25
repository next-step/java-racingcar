package lotto.step2.view;

import lotto.step2.domain.Lottos;

import java.util.List;

public class ResultView {
    public static final String TEXT_WIN_STAT = "당첨 통계";
    public static final String TEXT_LINE = "---------";
    public static final String[] TEXT_RESULT = {"총 수익률은 ", "입니다.", "(기준이 1이기 때문에 결과적으로 손해라는 의미임)", "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"};
    public StringBuilder stringBuilder = new StringBuilder();

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

    public void printWinnerStat(List<String> statResultList, double result) {
        System.out.println(TEXT_WIN_STAT);
        System.out.println(TEXT_LINE);
        statResultList.forEach(e -> stringBuilder.append(e).append("\n"));
        stringBuilder.append(TEXT_RESULT[0]).append(result).append(TEXT_RESULT[1]);
        if (result < 1) {
            stringBuilder.append(TEXT_RESULT[2]);
        } else {
            stringBuilder.append(TEXT_RESULT[3]);
        }
        System.out.println(stringBuilder);
    }
}
