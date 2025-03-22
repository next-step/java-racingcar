package view;

import domain.Car;
import domain.Cars;
import java.util.List;
import utils.StringUtils;

public class ResultView {


    public void broadcast(Cars cars) {
        for (Car car : cars.getCars()) {
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
