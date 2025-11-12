import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static final String LOCATION_INDICATOR = "-";

    public static void printResultHeader() {
        print("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        print(createCarsLocationString(cars));
    }

    public static void printWinners(List<Car> winners) {
        String names = createWinnerCarNamesString(winners);
        print(names + "가 최종 우승했습니다.");
    }

    private static String createCarsLocationString(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(getCarNameString(car)).append(getLocationString(car)).append("\n");
        }
        return sb.toString();
    }

    private static String createWinnerCarNamesString(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.name());
        }
        return String.join(", ", winnerNames);
    }

    private static String getCarNameString(Car car) {
        return car.name() + " : ";
    }

    private static String getLocationString(Car car) {
        return LOCATION_INDICATOR.repeat(car.currentLocation());
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
