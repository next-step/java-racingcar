package view;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printGameResult(List<Car> cars) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : cars) {
            winningCarNames.add(car.getName());
        }
        String result = String.join(", ", winningCarNames) + "가 최종 우승했습니다";
        System.out.println(result);
    }
}
