package racingcar;

import org.apache.commons.lang3.StringUtils;
import racingcar.utils.Constant;

public class ResultView {
    public static void printBattle(RacingResult result) {
        for (RacingCar racingCar : result.getRacingCars()) {
            String dashes = StringUtils.repeat(Constant.FORMAT_DASH, racingCar.getCoordinate());
            System.out.println(String.format("%s : %s", racingCar.getName(), dashes));
        }
        System.out.println("");
    }

    public static void printWinners(RacingResult result) {
        System.out.println(String.format("%s가 최종 우승했습니다", result.createDisplayWinnerNames()));
    }
}
