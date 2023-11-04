package car_racing;

import car_racing.ui.InputView;

public class CarRace {
    public static void main(String[] args) {
        Track track = InputView.input().toTrack();
        track.run();
    }
}
