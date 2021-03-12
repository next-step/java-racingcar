package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RacingRound;

public class ResultView {

    public static void printResultView(RacingRound resultRound) {
        int tryNum = resultRound.getRoundResult().size();

        for (int num = 0; num < tryNum; num++) {
            resultRound.getRoundResult().get(num).stream().map(ResultView::convertIntToString).forEach(System.out::println);
            System.out.println();
        }
    }

    private static String convertIntToString(int racingTrack) {
        StringBuffer str = new StringBuffer();

        for (int num = 0; num < racingTrack; num++) {
            str.append("-");
        }
        return str.toString();
    }

}
