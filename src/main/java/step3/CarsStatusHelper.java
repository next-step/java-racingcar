package step3;

public class CarsStatusHelper {

    public static String getCarsStatusView(RacingCars racingCars) {
        return getRacingCarsStatusBuilder(racingCars).toString();
    }

    private static StringBuilder getRacingCarsStatusBuilder(RacingCars racingCars) {
        StringBuilder racingCarsStatusBuilder = new StringBuilder();
        racingCars
                .getAll()
                .forEach(racingCar ->
                        racingCarsStatusBuilder
                                .append(getRacingCarStatus(racingCar))
                                .append("\n")
                );
        return racingCarsStatusBuilder;
    }

    private static String getRacingCarStatus(RacingCar racingCar) {
        StringBuilder statusBuilder = new StringBuilder();
        racingCar.getStatus().forEach(statusBuilder::append);
        return statusBuilder.toString();
    }
}
