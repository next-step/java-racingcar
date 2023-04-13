package study.step4;

import java.util.List;

public class ResultView {

    public void startMsg() {
        System.out.println("실행결과");
    }

    public void moveResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void getWinnerResult(List<String> winnerList) {
        StringBuilder winMsg = new StringBuilder();

        for (String winner : winnerList) {
            if (!winMsg.toString().isBlank()) winMsg.append(", ");
            winMsg.append(winner);
        }

        System.out.println(winMsg + "가 최종 우승했습니다.");
    }

    public void endingRoundMsg(int round) {
        System.out.println("... " + round + "st round end ...");
    }

    public void isNotReadyMsg() {
        System.out.println("please ready game before start game ... !!");
    }

    public void isNotEndMsg() {
        System.out.println("please end game before get winner ... !!");
    }
}
