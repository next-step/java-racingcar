package racingcar;

public class RacingCarMain {
    public static void main(String[] args) {
        new RacingCarGame(
            DefaultRacingCarGameWinnerStrategy.getInstance()).start();
    }
}
