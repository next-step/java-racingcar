package camp.nextstep.edu.rebellion.racing;

public class RacingGameRunner {
    public static void main(String[] args) {
        String cars = InputView.getCarNames();
        int rounds = InputView.getRounds();

        RacingGame game = new RacingGame(cars, rounds);
        Record record = game.start();

        ResultView.showResult(record);
    }
}
