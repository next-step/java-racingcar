package CarRacing.view;

import CarRacing.domain.Car;
import CarRacing.domain.RacingCars;

public class RacingView {
    static private final String BAR = "-";
    static private final String LINE_BREAK = "\n";
    static private final String COLON =" : ";

    public static String makeGauge(final int count) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(BAR);
        }

        sb.append(LINE_BREAK);
        return sb.toString();
    }

    public static void makeCarsCurrentStatusToString(final RacingCars racingCars) {
        final StringBuilder sb = new StringBuilder();
        for (Car car : racingCars.getRacingCars()) {
            sb.append(car.getName())
                    .append(COLON)
                    .append(makeGauge(car.getCurrentPosition()));
        }

        System.out.println(sb.toString());
    }
}
