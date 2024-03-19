package race.view;


import java.util.List;
import race.domain.Car;
import race.domain.Cars;

public class ResultView {

    private final static String END_OF_LINE = "\n";
    private final static String PROGRESS_BAR = "-";
    private final static String CAR_FORMAT = "%s : %s";
    private final static String WINNERS_FORMAT = "%s가 최종 우승했습니다.";

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

    public static void showWinners(List<Car> winners) {
        String winnerNames = joinWinnerNames(winners);
        System.out.println(String.format(WINNERS_FORMAT, winnerNames));
    }

    private static String joinWinnerNames(List<Car> winners) {
        String[] winnerNames = new String[winners.size()];

        for (int i = 0; i < winners.size(); i++) {
            winnerNames[i] = winners.get(i).getName();
        }
        return String.join(",", winnerNames);
    }

    private static String showCar(Car car) {
        return String.format(CAR_FORMAT,
                car.getName(),
                drawProgressBar(car.getPosition().getValue())
        );
    }

    private static String drawProgressBar(int count) {
        return PROGRESS_BAR.repeat(count);
    }
}
