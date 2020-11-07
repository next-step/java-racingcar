package step3.worker.interfaces.presenter;

import java.util.List;

import static step3.worker.interfaces.presenter.ViewString.WINNER_ANNOUNCEMENT;

public class WinnerResultViewPresenter implements Presenter {
    private final List<String> winnerNames;

    public WinnerResultViewPresenter(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public String present() {
        return String.join(",", winnerNames) + WINNER_ANNOUNCEMENT;
    }
}
