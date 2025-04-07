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

    public void printResult(List<Car> cars, int winningPosition) {
        List<Car> winningCars = new ArrayList<>();
        StringBuilder winningName = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() == winningPosition) {
                winningCars.add(car);
            }
        }

        for (int i = 0; i < winningCars.size(); i++) {
            winningName.append(winningCars.get(i).getName());
            if (i != winningCars.size() - 1) {
                winningName.append(", ");
            }
        }
        winningName.append("가 최종 우승했습니다.");
        System.out.println(winningName);
    }
}
