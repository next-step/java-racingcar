package racingcar;

public class RacingCarMain {
    public static void main(String[] args) {
        new RacingCarGame(
            new DefaultRacingCarGameWinnerStrategy())
            .start();
    }
}
