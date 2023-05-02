import controller.RacingController;
import domain.game.Race;
import domain.game.RacingResult;
import domain.request.RacingCarNameRequest;
import domain.request.RacingRoundRequest;
import view.InputView;
import view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingCarNameRequest carNamesRequest = new RacingCarNameRequest(InputView.inputNames());
        RacingRoundRequest racingRoundRequest = new RacingRoundRequest(InputView.inputNumberOfRounds());
        Race race = new Race(carNamesRequest);
        RacingResult racingResult = race.race(racingRoundRequest);
        RacingController controller = new RacingController();
        controller.returnGameResults(racingResult);
        controller.returnWinners(race.getWinners());
    }
}
