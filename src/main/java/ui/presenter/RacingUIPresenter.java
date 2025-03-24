package ui.presenter;

import model.Racing;

public interface RacingUIPresenter {
    void printCurrentStatus(Racing racing);

    void printWinner(Racing racing);
}
