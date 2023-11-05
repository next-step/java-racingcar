package carracing.ui;

import carracing.TrackHistory;

public class OutputView {
    private final TrackHistory trackHistory;

    private OutputView(TrackHistory trackHistory) {
        this.trackHistory = trackHistory;
    }

    public static OutputView from(TrackHistory trackHistory) {
        return new OutputView(trackHistory);
    }

    public void outputs() {
        trackHistory.getCarsHistory()
                .forEach(cars -> {
                    cars.getCars().forEach(car -> output(car.getPosition()));
                    System.out.println("\n");
                });
    }

    private void output(int position) {
        System.out.println(String.valueOf('-').repeat(position));
    }
}
