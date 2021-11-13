package racinggame;

import racinggame.domain.CarStateGenerator;
import racinggame.domain.Laps;
import racinggame.domain.Names;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        CarStateGenerator carStateGenerator = new CarStateGenerator();
        InputView inputView = new InputView();

        try {
            Names names = inputView.inputEntryCarNames();
            Laps laps = inputView.inputLaps();

            RacingGame racingGame = new RacingGame(names, laps, carStateGenerator);
            racingGame.startRacing();
            ResultView.awardRacing(racingGame.getCars());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
