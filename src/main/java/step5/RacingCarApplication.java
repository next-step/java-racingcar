package step5;

import step5.domain.RacingInformation;
import step5.domain.Stage;
import step5.strategy.move.RandomMoveStrategy;
import step5.view.InputView;
import step5.view.PrintView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingInformation racingInformation = InputView.execute();
        Stage stage = new Stage(racingInformation);

        while (stage.hasMoreStage()) {
            stage.play(RandomMoveStrategy.getInstance());
            PrintView.printAllRacingCarProgress(racingInformation.getRacingCarGroup());
        }

        PrintView.printWinner(racingInformation.getRacingCarGroup().getWinner());

    }

}
