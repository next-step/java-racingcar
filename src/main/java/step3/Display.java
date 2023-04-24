package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Display {

    public static void printDisplay(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(": ").append("-".repeat(car.getLocation())).append("\n");
        }
        System.out.println(sb);
    }

    public static void notifyWinners(List<Car> cars) {
        if (cars.isEmpty()) {
            return;
        }
        List<String> winners = cars.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(getWinnerAnnouncement(winners));
    }

    private static StringBuilder getWinnerAnnouncement(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        return sb;
    }
}
