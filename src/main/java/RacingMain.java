import domain.game.Race;
import domain.request.RacingCarNameRequest;
import domain.request.RacingRoundRequest;
import view.InputView;
import view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingCarNameRequest carNamesRequest = new RacingCarNameRequest(InputView.inputNameList());
        RacingRoundRequest racingRoundRequest = new RacingRoundRequest(InputView.inputNumberOfRounds());
        Race race = new Race(carNamesRequest);
        ResultView.outputView(race.race(racingRoundRequest));
        ResultView.printWinner(race.getWinnerList());
    }
}
