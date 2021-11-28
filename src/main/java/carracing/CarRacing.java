package carracing;

import java.util.List;

public class CarRacing {
    public static void main(String[] args) {
        List<CarName> carNames = InputView.inputCarNames();
        int round = InputView.inputRound();

        InputView.print("실행 결과");

        Track track = new Track(carNames);
        RandomStepForwardStrategy randomStepForwardStrategy = new RandomStepForwardStrategy();

        Rounds rounds = new Rounds();
        for (int i = 0; i < round; i++) {
            Round currentRound = track.forward(randomStepForwardStrategy);
            rounds.add(currentRound);
        }

        ResultView.printRounds(rounds.getRounds());
        ResultView.printWinner(rounds.getWinners());
    }
}
