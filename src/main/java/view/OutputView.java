package view;

import domain.RacingGame;

public class OutputView {

    private final RacingGame racingGame;
    private final int count;

    public OutputView(RacingGame racingGame, int count) {
        this.racingGame = racingGame;
        this.count = count;
    }

    public void printResult() {
        int count = this.count;
        System.out.println("실행 결과");
        System.out.print(racingGame.playResult(count));
    }

    public static void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
