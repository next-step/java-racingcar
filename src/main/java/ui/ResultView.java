package ui;


import model.Racing;
import ui.presenter.RacingConsoleUIPresenter;
import ui.presenter.RacingUIPresenter;

public class ResultView {

    private final RacingUIPresenter racingUIPresenter = new RacingConsoleUIPresenter();

    public void doRaceAndPrintResult(Racing racing) {
        System.out.println("실행 결과");

        racing.moveUntilFinish();

        this.racingUIPresenter.printCurrentStatus(racing);
        this.racingUIPresenter.printWinner(racing);
    }
}
