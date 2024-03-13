package race.view;


import java.util.List;
import race.domain.Car;
import race.domain.Cars;

public class ResultView {

    private final static String END_OF_LINE = "\n";
    private final static String PROGRESS_BAR = "-";
    private final static String CAR_FORMAT = "%s : %s";

    public static void start() {
        System.out.println("실행 결과");
    }

    public static void showProcess(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            sb.append(showCar(car)).append(END_OF_LINE);
        }
        System.out.println(sb);
    }

    private static String showCar(Car car) {
        return String.format(CAR_FORMAT, car.getName(),drawProgressBar(car.getCountOfMove()));
    }

    private static String drawProgressBar(int count) {
        return PROGRESS_BAR.repeat(count);
    }
}
