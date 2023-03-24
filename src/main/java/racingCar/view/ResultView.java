package racingCar.view;

import java.util.List;
import racingCar.domain.Car;

public class ResultView {

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            showPosition(car.getName(), car.getPosition());
        }
        System.out.println("");
    }
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자: " + toString(winners));
    }
    public String toString(List<String> cars) {
        return String.join(", ", cars);
    }
    public void showPosition(final String name, final int position) {
        StringBuilder sb = new StringBuilder();
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
