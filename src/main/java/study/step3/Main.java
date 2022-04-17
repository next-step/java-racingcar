package study.step3;

public class Main {
    public static void main(String[] args) {
        new InputView().configRacingcarGame();
        new RacingcarGame().startRacingcarGame();
        new ResultView().print();
    }
}
