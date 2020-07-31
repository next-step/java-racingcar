package camp.nextstep.edu.rebellion.racing;

public class RacingGameRunner {
    public static void main(String[] args) {
        int carNumbers = InputView.getCarNumbers();
        int rounds = InputView.getRounds();

        RacingGame game = RacingGame.ready(carNumbers, rounds);
        Record record = game.start();

        ResultView.showResult(record);
    }
}
