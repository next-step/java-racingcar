package racing;

public class GameMachine {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RandomRoulette());
        racingGame.start();
    }
}
