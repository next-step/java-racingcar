package study.racing.view;

import study.racing.model.Car;

import java.util.Arrays;
import java.util.List;

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

    public void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder(winners.get(0).getName());

        for(int i=1; i<winners.size(); i++) {
            winnerNames.append(", ").append(winners.get(i).getName());
        }

        System.out.print(winnerNames.toString() + "가 최종 우승했습니다.\n");
    }


}
