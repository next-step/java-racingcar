package racinggame.view;

import racinggame.core.ScoreBoard;

public class ScoreScreen {

    public static void printScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("실행 결과");

        for (int i = 1; i <= scoreBoard.getNumOfGame(); i++) {
            int[] distances = scoreBoard.getDistanceOfGame(i);
            for (int distance : distances) {
                System.out.println("-".repeat(distance));
            }
            System.out.println();
        }
    }

}
