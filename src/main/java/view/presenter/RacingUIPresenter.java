package view.presenter;

import domain.Racing;

public interface RacingUIPresenter {
    void printCurrentStatus(Racing racing);

    void printWinner(Racing racing);
}
