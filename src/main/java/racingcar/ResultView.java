package racingcar;

import com.google.common.base.Strings;

public class ResultView {

    public static void printResult(RacingResult result) {
        for(Car car : result.getCars()) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printWinners(RacingResult result) {
        String winners = RacingUtil.getJoiningName(result.getWinners());

        System.out.println(winners + "가 최종 우승했습니다.");
    }


    private static void printPosition(int position) {
        System.out.println(Strings.repeat("-", position));
    }

}
