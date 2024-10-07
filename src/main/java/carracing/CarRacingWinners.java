package carracing;

import carracing.car.Cars;

public class CarRacingWinners {

    public static Cars findWinners(Cars cars) {
        int maxPosition = -1;
        maxPosition = getMaxPosition(cars, maxPosition);

        return findWinners(cars, maxPosition);
    }

    private static int getMaxPosition(Cars cars, int maxPosition) {
        return cars.compareMax(maxPosition);
    }

    private static Cars findWinners(Cars cars, int maxPosition) {
        return cars.getCarsSamePositionAs(maxPosition);
    }

}
