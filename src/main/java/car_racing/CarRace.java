package car_racing;

import car_racing.ui.InputView;
import car_racing.ui.OutputView;

public class CarRace {
    public static void main(String[] args) {
        InputView inputView = InputView.input();
        Track track = inputView.toTrack();
        OutputView outputView = OutputView.from(track);
        for (int i = 0; i < inputView.getMovingCount(); i++) {
            track.run();
            outputView.outputs();
        }
    }
}
