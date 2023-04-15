package step3;

import step3.domain.UsingNameCarRacingInformation;
import step3.domain.UsingRacingCarStage;
import step3.strategy.move.MoveStrategy;
import step3.view.InputView;
import step3.view.UsingNameCarPrintView;

public class UsingNameRacingCarGame extends AbstractRacingCarGame<UsingNameCarRacingInformation> {

    private final InputView<UsingNameCarRacingInformation> inputView;
    private final MoveStrategy moveStrategy;

    public UsingNameRacingCarGame(InputView inputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.moveStrategy = moveStrategy;
    }

    @Override
    UsingNameCarRacingInformation getRacingInformation() {
        return inputView.execute();
    }

    @Override
    UsingNameCarRacingInformation play(UsingNameCarRacingInformation racingInformation) {

        while (racingInformation.isContinue()) {
            UsingRacingCarStage usingRacingCarStage = UsingRacingCarStage.of(racingInformation.getCurrentReps(), racingInformation.getRacingCarList()).play(moveStrategy);
            UsingNameCarPrintView.printAllRacingCarProgress(usingRacingCarStage);
        }

        return racingInformation;
    }

    @Override
    void showResult(UsingNameCarRacingInformation racingInformation) {
        UsingNameCarPrintView.printWinner(racingInformation.getWinner());
    }

}
