package carracing.view;

import carracing.domain.Car;
import carracing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class Display {

    public static void printCurrentStatus(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.get()) {
            sb.append(car.getName()).append(": ").append("-".repeat(car.getLocation())).append("\n");
        }
        System.out.println(sb);
    }

    public static void printWinnerAnnouncement(List<Car> cars) {
        List<String> winners = cars.stream().map(Car::getName).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
