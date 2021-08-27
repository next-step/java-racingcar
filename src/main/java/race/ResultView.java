package race;

public class ResultView {

    protected static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " :" + convertDistanceToLine(car));
        }
        System.out.println();
    }

    private static String convertDistanceToLine(Car car) {
        StringBuilder sb = new StringBuilder();
        for (Boolean b : car.getDistance()) {
            sb.append(b ? "-" : "");
        }
        return sb.toString();
    }
}
