package step3;

import java.util.List;

public class ResultView {

    private int maxScore = 0;
    private String winner = "";

    public void racingView(List<Integer> carPositions, String[] carName) {
        for (int i = 0; i < carPositions.size(); i++) {
            System.out.print(carName[i] + " : ");
            outputView(carPositions.get(i));
            maxScore = (maxScore < carPositions.get(i) ? carPositions.get(i) : maxScore);
        }
        System.out.println();
    }

    private void outputView(int num) {
        for (int i = num; i > 0; i--) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void findMaxScoreWinner(List<Integer> carPositions, String[] carName) {
        for (int i = 0; i < carPositions.size(); i++) {
            findWinner(i, carPositions, carName);
        }
        System.out.print(winner.substring(0, winner.length() - 2));
        System.out.println("가 최종 우승했습니다.");
    }

    private void findWinner(int index, List<Integer> carPositions, String[] carName) {
        if (carPositions.get(index) == maxScore) {
            winner += carName[index] + ", ";
        }
    }
}
