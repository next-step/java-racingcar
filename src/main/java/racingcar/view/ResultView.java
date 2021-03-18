package racingcar.view;

import racingcar.Constant;
import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.domain.RacingRound;

import java.util.stream.Collectors;

public class ResultView {

    public static void printResultView(RacingRound resultRound, Winner winner) {
        int tryNum = resultRound.getRoundResult().size();

        for (int num = 0; num < tryNum; num++) {
            resultRound.getRoundResult().get(num).stream()
                    .map(ResultView::convertIntToString)
                    .forEach(System.out::println);

            System.out.println();
        }

        System.out.println(winner.getWinner().stream().collect(Collectors.joining(",")) + "가 최종우승했습니다.");
    }

    private static String convertIntToString(Car car) {
        StringBuffer str = new StringBuffer();

        str.append(car.getName() + ":");
        for (int num = Constant.INPUT_ZERO_NUM; num < car.getPosition(); num++) {
            str.append("-");
        }
        return str.toString();
    }
}
