package step5.worker.interfaces.render;

import java.util.List;

public class WinnerResultViewRender implements ViewRender {
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    private final List<String> winnerNames;

    public WinnerResultViewRender(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public String render() {
        return String.join(",", winnerNames) + WINNER_ANNOUNCEMENT;
    }
}
