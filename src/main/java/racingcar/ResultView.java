package racingcar;

import java.util.Map;

public class ResultView {

    public static void show(Map<Integer, Integer> racingStatus) {
        printHead();

        printCarForwardStatus(racingStatus);
    }

    private static void printHead() {
        System.out.println("");
        System.out.println("");
        System.out.println("실행결과");
    }

    private static void printCarForwardStatus(Map<Integer, Integer> racingStatus) {
        for (Integer integer : racingStatus.keySet()) {
            printDash(racingStatus.get(integer));
        }
    }

    private static void printDash(int forwardValue) {
        for (int j = 0; j < forwardValue; j++) {
            System.out.print("-");
        }
        System.out.println();
    }





}
