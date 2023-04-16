package step4.view;

import step4.domain.Separator;
import step4.domain.UsingNameRacingCar;
import step4.domain.UsingRacingCarStage;

import java.util.List;

public class UsingNameCarPrintView {

    public static void printAllRacingCarProgress(UsingRacingCarStage usingRacingCarStage) {
        usingRacingCarStage.getCarList().forEach(UsingNameCarPrintView::printRacingCarProgress);
    }

    private static void printRacingCarProgress(UsingNameRacingCar racingCar) {

        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getCurrentLocation(); i++) {
            System.out.print(Separator.PROGRESS_DRAW_SEPARATOR.getSeparator());
        }
        System.out.println();
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println();
        System.out.println(String.join(Separator.SPLIT_CAR_NAME_SEPARATOR.getSeparator(), winner) + "가 최종 우승했습니다!");
    }

}
