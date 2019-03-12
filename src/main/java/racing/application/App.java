package racing.application;

import racing.infrastructure.RandomCondition;
import racing.ui.GameConsole;
import racing.ui.GameReady;
import racing.view.RacingRequestView;

public class App {

    public static void main(String[] args) {
        RacingRequestView request = GameReady.set();
        RacingGame game = new RacingGame(request, new RandomCondition());
        GameConsole.preView(game.getViews());

        game.start();

        GameConsole.resultViews(game.getHistory());
        GameConsole.winnersView(game.judgeWinners());
    }
}
