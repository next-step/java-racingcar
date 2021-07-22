package racingcar.view;

import racingcar.vehicle.Cars;

public class ResultView {

    private static final char PRINT_FLAG = '-';

    public static void pirntProgress(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.getCarName(i);
            int distance = cars.getDistance(i);

            System.out.println(carName + " : " + getDistanceString(distance));
        }
        System.out.println();
    }

    private static String getDistanceString(int distance) {
        StringBuilder distanceString = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            distanceString.append(PRINT_FLAG);
        }

        return distanceString.toString();
    }
}
