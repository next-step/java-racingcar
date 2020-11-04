package step3.view.output.presenter;

import java.util.List;

import static step3.view.ViewString.WINNER_ANNOUNCEMENT;

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
