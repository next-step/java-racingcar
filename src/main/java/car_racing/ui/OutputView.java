package car_racing.ui;

import car_racing.Track;

public class OutputView {
    private final Track track;

    private OutputView(Track track) {
        this.track = track;
    }

    public static OutputView from(Track track) {
        return new OutputView(track);
    }

    public void output() {
        track.getCars().forEach(car -> {
            System.out.println(String.valueOf('-').repeat(car.getPosition()));
        });
        System.out.println("\n");
    }
}
