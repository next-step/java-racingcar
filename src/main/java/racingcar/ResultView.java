package racingcar;

import java.util.List;

public class ResultView {

    public static void printResultStart() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<LaneViewModel> lanes) {
        for (LaneViewModel lane: lanes) {
            printLane(lane);
        }

        System.out.println();
    }

    public static void printLane(LaneViewModel lane) {
        System.out.print(lane.getName() + ": ");
        for (int i = 0; i < lane.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
