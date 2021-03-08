package racing;

import java.util.*;

public class RacingSimulator {
    static final List<Driver> drivers = new ArrayList<>();

    public static void main(String[] args) {
        final RacingData data = showInputView();

        populateDrivers(data.getCarsCount());

        showResultView(data.copyWith(drivers));
    }

    private static RacingData showInputView() {
        return new InputView().show();
    }

    private static void populateDrivers(int carsCount) {
        for (int i = 0; i < carsCount; i++) {
            drivers.add(new Driver(new Car()));
        }
    }

    private static void showResultView(RacingData data) {
        new ResultView().show(data);
    }
}
