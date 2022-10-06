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

    public static void printWinner(List<String> winnerNames) {
        System.out.print(winnerNames.get(0));
        for (int i = 1; i < winnerNames.size(); i++) {
            System.out.print(", ");
            String winnerName = winnerNames.get(i);
            System.out.print(winnerName);
        }
        System.out.println("이(가) 최종 우승했습니다.");
    }
}
