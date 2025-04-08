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

    public void printResult(List<String> winningCars) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < winningCars.size(); i++) {
            result.append(winningCars.get(i));
            addCommaIfNeeded(result, i, winningCars.size());
        }
        result.append("가 최종 우승했습니다.");
        System.out.println(result);
    }

    void addCommaIfNeeded(StringBuilder result, int currentIndex, int size) {
        if (currentIndex != size - 1) {
            result.append(", ");
        }
    }
}
