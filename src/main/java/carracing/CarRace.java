package carracing;

import carracing.ui.InputView;
import carracing.ui.OutputView;

public class CarRace {
    public static void main(String[] args) {
        InputView inputView = InputView.input();
        Track track = inputView.toTrack();
        track.run();
        OutputView.from(track.getTrackHistory()).outputs();
    }
}
