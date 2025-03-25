package view;


import domain.Racing;
import view.presenter.RacingConsoleUIPresenter;
import view.presenter.RacingUIPresenter;

public class ResultView {

    private final RacingUIPresenter racingUIPresenter = new RacingConsoleUIPresenter();

    public void doRaceAndPrintResult(Racing racing) {
        System.out.println("실행 결과");

        while(racing.isRemainTry()){
            racing.moveOnce();
            racingUIPresenter.printCurrentStatus(racing);
        }

        this.racingUIPresenter.printCurrentStatus(racing);
        this.racingUIPresenter.printWinner(racing);
    }
}
