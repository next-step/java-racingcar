package car_racing;

import car_racing.ui.InputView;
import car_racing.ui.OutputView;

public class CarRace {
    public static void main(String[] args) {
        Track track = InputView.input().toTrack();
        OutputView outputView = OutputView.from(track);
        track.run();
        outputView.output();
    }
}
