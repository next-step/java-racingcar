import domain.RacingGame;
import domain.Winners;
import view.InputView;
import view.InputViewDto;
import view.OutputView;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputViewDto input = inputView.init();
        RacingGame racingGame = new RacingGame(input.getName(), input.getRound());
        OutputView output = new OutputView();
        output.printProcedure(racingGame);
        Winners winners = new Winners(racingGame);
        output.printWinners(winners);
    }
}
