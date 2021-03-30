package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {

    private String result = "";

    public void showRoundResult(String result) {
        this.result += result;
    }

    public void showResult() {
        System.out.println(result);
    }

    public void showWinner(List<RacingCar> winnerList) {

        String winner = "";

        if (winnerList.isEmpty()) {
            System.out.println("");
        }

        for (int i = 0; i < winnerList.size(); i++) {
            winner += winnerList.get(i).getOwner() + ",";
        }

        winner = winner.replaceFirst(".$", "") + "가 최종 우승했습니다.";

        System.out.println(winner);
    }

    public String showCarStatus(String owner, int location) {
        String status = "";

        for (int i = 0; i < location; i++) {
            status += "-";
        }

        result += owner + " : " + status + "\n";

        return result;
    }
}
