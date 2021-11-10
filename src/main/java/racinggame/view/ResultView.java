package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Location;

public class ResultView {

    private static final String DASH = "-";

    private ResultView() {
    }

    public static void currentRecord(Cars cars) {
        for (Car car : cars.getCars()) {
            locationResult(car.getLocation());
        }
        System.out.println();
    }

    public static void locationResult(Location location) {
        StringBuilder racingRecord = new StringBuilder();
        for (int i = 0; i < location.getLocation(); i++) {
            racingRecord.append(DASH);
        }
        System.out.print("\n" + racingRecord);
    }
}
