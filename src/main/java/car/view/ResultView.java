package car.view;

import car.domain.Car;

import java.util.List;

public class ResultView {
    public static void printRaceResult(List<Car> cars, String format) {
        System.out.println();
        for (Car car : cars) {
            int position = car.getPosition();
            String carStatus = car.getName() + " : " + format.repeat(position);
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

}
