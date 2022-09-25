package step3;

import java.util.List;

public class ResultView {

    public static final String EMPTY_STRING = "";
    private static final String PROCESS_BAR = "-";

    private final RacingGame racingGame;

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void playWithMoveStrategy(MoveStrategy moveStrategy) {
        System.out.println("실행 결과");
        while (!racingGame.isEnd()) {
            racingGame.race(moveStrategy);
            showCurrentPositions(racingGame.currentPositions());
        }
    }

    private void showCurrentPositions(List<Integer> currentPositions) {
        currentPositions.forEach(position -> expressWithProcessBar(position));
        System.out.println();
    }

    private void expressWithProcessBar(Integer position) {
        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < position; i++) {
            sb.append(PROCESS_BAR);
        }
        System.out.println(sb);
    }
}



