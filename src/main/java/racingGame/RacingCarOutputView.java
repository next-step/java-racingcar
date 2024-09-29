package racingGame;

import java.util.List;

public class RacingCarOutputView {
    public void printGameStart() {
        System.out.println("실행 결과");
    }

    public void printGameState(List<Integer> carPositions) {
        for (int position : carPositions) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }

    public void printGame(List<List<Integer>> gameStates) {
        printGameStart();
        for (List<Integer> state : gameStates) {
            printGameState(state);
        }
    }
}