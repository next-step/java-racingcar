package view;

import java.util.List;
import racing.Car;
import racing.SimpleCar;
import utils.StringUtils;

public class ResultView {

    private List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void broadcast() {
        for (Car car : cars) {
            printPosition(car);
            System.out.println();
        }
    }

    private void printPosition(Car car) {
        System.out.print(!StringUtils.isEmpty(car.name()) ? car.name() + " : " : "");
        System.out.print("-".repeat(car.currentPosition()));
    }

    public void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
