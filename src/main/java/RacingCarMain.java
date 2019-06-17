import racingcar.controller.RacingGame;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        boolean isGameEnd = racingGame.run();

        if (!isGameEnd) {
            System.out.println("경주가 진행되지 못했습니다.");
        }
    }
}
