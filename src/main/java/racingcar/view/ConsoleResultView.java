package racingcar.view;

import java.util.List;

public class ConsoleResultView implements ResultView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<LaneViewModel> lanes) {
        for (LaneViewModel lane: lanes) {
            printLane(lane);
        }

        System.out.println();
    }

    private void printLane(LaneViewModel lane) {
        System.out.print(lane.getName() + ": ");
        for (int i = 0; i < lane.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(winners + "이(가) 최종 우승했습니다.");
    }
}
