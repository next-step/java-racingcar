package racing;

import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputDto;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        InputDto inputDto = inputView.InputCountOfUnit();

        RacingGame game = new RacingGame(inputDto.input(), inputDto.count());
        List<Cars> results = game.playGame();
        List<String> winners = game.winners();

        ResultView.printCarsLocations(results);
        ResultView.printWinners(winners);
    }
}
