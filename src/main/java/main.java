import domain.Race;
import domain.RacingCarNameRequest;
import domain.RacingRoundRequest;
import view.InputView;
import view.ResultView;

public class main {
    public static void main(String[] args) {
        RacingCarNameRequest request = new RacingCarNameRequest(InputView.inputNameList());
        Race.createCars(request);

        RacingRoundRequest racingRoundRequest = new RacingRoundRequest(InputView.inputNumberOfRounds());
        ResultView.outputView(Race.playRace(racingRoundRequest));
        ResultView.printWinner(Race.getWinnerList());
    }
}
