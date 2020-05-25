package study.racing.view;

import study.racing.model.Car;
import study.racing.model.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final char CAR_MOVED = '-';

    public void printCarPositions(List<Car> cars) {
        for(Car car : cars) {
            char[] chars = new char[car.getPosition()];
            Arrays.fill(chars, CAR_MOVED);

            System.out.print(car.getName() + " : ");
            System.out.println(chars);
        }

        System.out.println();
    }

    public void printWinners(List<Winner> winners) {
        String winnerNames = winners.stream().map(Winner::getName).collect(Collectors.joining(", "));

        System.out.print(winnerNames + "가 최종 우승했습니다.\n");
    }
}
