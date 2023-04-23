package step5;

import step5.domain.RacingInformation;
import step5.domain.Stage;
import step5.strategy.move.RandomMoveStrategy;
import step5.view.PrintView;

public class RacingCarService {

    private final RacingInformation racingInformation;
    private final Stage stage;

    public RacingCarService(RacingInformation racingInformation, Stage stage) {
        this.racingInformation = racingInformation;
        this.stage = stage;
    }

    public void startRacing() {
        while (stage.hasMoreStage()) {
            stage.play(RandomMoveStrategy.getInstance());
            PrintView.printAllRacingCarProgress(racingInformation.getRacingCarGroup());
        }

        PrintView.printWinner(racingInformation.getRacingCarGroup().getWinner());
    }

}
