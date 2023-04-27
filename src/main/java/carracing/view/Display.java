package carracing.view;

import carracing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Display {

    public static String getCurrentStatus(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(": ").append("-".repeat(car.getLocation())).append("\n");
        }
        return sb.toString();
    }

    public static String getWinnerAnnouncement(List<Car> cars) {
        List<String> winners = cars.stream().map(Car::getName).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        return sb.toString();
    }
}
