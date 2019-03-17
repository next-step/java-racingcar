package racing;

import racing.service.RacingGameService;
import racing.ui.GameConsole;
import racing.ui.GameReady;
import racing.view.RacingGameRequestView;
import racing.view.RacingGameResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        RacingGameRequestView request = GameReady.set();
        RacingGameResultView result = RacingGameService.run(request);
        GameConsole.resultShow(result);
    }
}
