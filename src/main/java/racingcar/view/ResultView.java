package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String START_RESULT_MESSAGE = "실행 결과";
    private static List<String> winner;
    private static int max = 0;

    public static void drawResult(Cars cars) {
        cars.carList().forEach(car -> {
            System.out.println(drawEachCar(car.getStatusLine(), car.getCarName()));
        });
        System.out.println("");
    }

    private static String drawEachCar(int statusLine, String carName) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName + " : ");
        for (int i = 0; i < statusLine; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static int getWinnerStatus(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getStatusLine))
                .get()
                .getStatusLine();
    }

    public static void printRacingWinner(List<Car> cars, int maxStatus) {
        String winnerMessage = cars.stream()
                .filter(car -> car.getStatusLine() == maxStatus)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerMessage + "(이)가 최종 우승했습니다.");
    }

    public static void lastView(List<Car> cars) {
        int maxStatus = getWinnerStatus(cars);
        printRacingWinner(cars, maxStatus);
    }

    public static String startResultMessage() {
        return START_RESULT_MESSAGE;
    }
}
