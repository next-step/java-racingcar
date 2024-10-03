package study.step_4.ui;

import java.util.List;

public class OutputView {

    public static final String COMMA = ", ";

    public void endGameMessage() {
        System.out.println(InfoMessage.EXECUTION_RESULT.getMessage());
    }

    public void cantDrive(String name, int distance) {
        if (distance == 0) {
            System.out.println(name + " : " + InfoMessage.WHEEL_LOSS.getMessage());
        }
    }

    public void SkidMark(String name, int distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print((InfoMessage.SKID_MARK.getMessage()));
        }
        System.out.println();
    }

    public void winnerAwards(List<String> winnersList) {
        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < winnersList.size(); i++) {
            winners.append(winnersList.get(i));
            avaliableMoreWinner(winnersList, i, winners);
        }

        System.out.println(winners + " " + InfoMessage.FINAL_WINNER.getMessage());
    }

    private static void avaliableMoreWinner(List<String> winnersList, int i, StringBuilder winners) {
        if (i < winnersList.size() - 1) {
            winners.append(COMMA);
        }
    }
}
