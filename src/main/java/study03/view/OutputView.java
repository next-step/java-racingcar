package study03.view;

import study03.model.RacingResult;
import study03.model.RoundResult;

import java.util.stream.IntStream;

/*
 *
 * OutputView
 *
 * @version 1.0.0
 *
 * 2021-11-11
 *
 * Copyright tnals1422
 */
public class OutputView {

    private static final String POSITION_SYMBOL = "-";
    private final RacingResult racingResult;

    public OutputView(RacingResult racingResult) {
        this.racingResult = racingResult;
    }

    public void printGameResult() {
        System.out.println("실행 결과");
        racingResult.getResult().forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundResult roundResult) {
        roundResult.getResult().forEach(carResult -> System.out.println(convertPositionToSymbol(carResult)));
        System.out.println();
    }

    private String convertPositionToSymbol(Integer carResult) {
        String result = "";
        if (carResult > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            IntStream.range(0, carResult)
                    .forEach(j -> stringBuilder.append(POSITION_SYMBOL));
            result = stringBuilder.toString();
        }
        return result;
    }
}
