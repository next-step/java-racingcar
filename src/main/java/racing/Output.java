package racing;

public class Output {
    final static String DASH = "-";

    public static void showSessionStatus(Game game) {
        for (Car car : game.getAttendedCars()) {
            showDistance(car);
        }
        System.out.println();
    }

    public static void showDistance(Car car) {
        String distanceIndicator = DASH.repeat(car.getCurrentLocation());
        System.out.println(distanceIndicator);
    }
}
