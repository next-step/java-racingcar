public class ResultView {
    public static final String LOCATION_INDICATOR = "-";

    public static void printResultHeader() {
        print("실행 결과");
    }

    public static void printResult(Cars cars) {
        print(createCarsLocationString(cars));
    }

    private static String createCarsLocationString(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.cars) {
            sb.append(getLocationString(car)).append("\n");
        }
        return sb.toString();
    }

    private static String getLocationString(Car car) {
        return LOCATION_INDICATOR.repeat(car.currentLocation);
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
