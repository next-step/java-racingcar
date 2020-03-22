package racingcar;

import java.util.ArrayList;

public class RacingGameView {

    private RacingGame racingGame;

    public RacingGameView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void viewCarPositions() {
        ArrayList<Integer> currentCarPositions = this.racingGame.getCurrentCarPositions();

        for (int i = 0; i < currentCarPositions.size(); i++) {
            printCarPosition(currentCarPositions.get(i));
            if (i == currentCarPositions.size() - 1) {
                System.out.println();
            }
        }
    }

    private void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
