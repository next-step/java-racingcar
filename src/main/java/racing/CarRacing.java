package racing;

import java.util.List;

public class CarRacing {
    private Cars cars;

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

    private void start() {
        participateCars();
        play();
    }

    private void play() {
        int rounds = InputView.inputRounds();
        ResultView.printResultTitle();
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceRoundResult(i);
        }
        announceWinner();
    }

    private void announceWinner() {
        List<String> winnerNames = cars.findWinners();
        ResultView.printWinners(winnerNames);
    }

    private void playRound() {
        cars.run();
    }

    private void participateCars() {
        String names = InputView.inputCarNames();
        cars = new Cars(names);
    }

    private void announceRoundResult(int round) {
        ResultView.printRound(round);
        cars.printDistance();
        ResultView.printNewLine();
    }
}
