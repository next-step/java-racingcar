package step3.racingcar;

import java.util.List;

public class ResultViewProcessor {

    private static final String RESULT_MEESAGE = "실행 결과";

    private static boolean isFirst = true;

    private ResultViewProcessor() {
    }

    public static void printResult(List<RacingCar> racingCarList) {
        int listSize = racingCarList.size();
        if (isFirst == true) {
            System.out.println(RESULT_MEESAGE);
            isFirst = false;
        }
        for (int i = 0; i < listSize; i++) {
            printCurrentPosition(racingCarList.get(i));
        }
        System.out.println();
    }

    private static void printCurrentPosition(RacingCar racingCar) {
        int currentPosition = racingCar.getPosition();
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
