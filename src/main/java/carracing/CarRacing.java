package carracing;

import java.util.List;

public class CarRacing {
    public static void main(String[] args) {
        List<CarName> carNames = InputView.inputCarNames();
        int round = InputView.inputRound();

        InputView.print("실행 결과");

        Track track = new Track(carNames);

        ResultBoard resultBoard = new ResultBoard();
        for (int i = 0; i < round; i++) {
            Round currentRound = track.forward();
            resultBoard.add(currentRound);
        }

        List<Round> rounds = resultBoard.getRounds();
        ResultView.printRounds(rounds);

        List<CarName> winnerCarNames = resultBoard.getWinners();
        ResultView.printWinner(winnerCarNames);
    }
}
