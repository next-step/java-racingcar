package step5.worker.interfaces.render;

import java.util.List;

import static step5.worker.interfaces.render.ViewString.WINNER_ANNOUNCEMENT;

public class WinnerResultViewRender implements ViewRender {
    private final List<String> winnerNames;

    public WinnerResultViewRender(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public String render() {
        return String.join(",", winnerNames) + WINNER_ANNOUNCEMENT;
    }
}
