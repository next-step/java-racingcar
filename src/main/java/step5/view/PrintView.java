package step5.view;

import step5.domain.RacingCar;
import step5.domain.RacingCarGroup;
import step5.domain.Separator;

import java.util.List;

public class PrintView {


    public static void printAllRacingCarProgress(RacingCarGroup racingCarGroup) {
        racingCarGroup.getRacingCarList().forEach(PrintView::printRacingCarProgress);
    }

    private static void printRacingCarProgress(RacingCar racingCar) {

        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getCurrentLocation(); i++) {
            System.out.print(Separator.PROGRESS_DRAW_SEPARATOR.getSeparator());
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println(String.join(Separator.SPLIT_CAR_NAME_SEPARATOR.getSeparator(), winner) + "가 최종 우승했습니다!");
    }

}
