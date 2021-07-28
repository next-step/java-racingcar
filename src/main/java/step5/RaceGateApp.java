package step5;

import step5.action.RaceGame;
import step5.domain.Cars;
import step5.domain.strategy.*;
import step5.view.InputData;
import step5.view.InputView;
import step5.view.ResultView;

public class RaceGateApp {
    // Setting Value
    private static final int MOVE_BOUNDARY = 4;
    private static final int RANDOM_BOUNDARY = 10;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        String[] names = InputView.inputCount();
        int times = InputView.inputTimes();
        InputData input = InputData.of(names, times);
        playGame(input);
    }

    private static void playGame(InputData input) {
        RaceGame game = RaceGame.of(Cars.from(input.getNames()));

        MoveStrategy strategy = new RandomNumberMoveStrategy(MOVE_BOUNDARY,RANDOM_BOUNDARY);

        for(int i=0; i<input.getTimes(); i++){
            game.move(strategy);
            ResultView.showAroundRace(game.getCars());
        }

        ArrangeStrategy arrangeStrategy = new CarsArrangeStrategy();
        WinnerStrategy winnerStrategy = new WinnerStrategyImpl();
        ResultView.showWinner(game.getWinner(winnerStrategy,arrangeStrategy));
    }

}
