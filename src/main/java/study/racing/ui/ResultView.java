package study.racing.ui;

import study.racing.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultView {
    private static final char CAR_MOVED = '-';

    public void printCarPositions(List<Car> cars) {
        for(Car car : cars) {
            char[] chars = new char[car.getCount()];
            Arrays.fill(chars, CAR_MOVED);

            System.out.print(car.getName() + " : ");
            System.out.println(chars);
        }

        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        String winnerNamesString = getWinnerNames(cars).toString();

        System.out.println(winnerNamesString.substring(1, winnerNamesString.length()-1)
                + "가 최종 우승했습니다.");
    }

    private List<String> getWinnerNames(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();

        Collections.sort(cars);
        Collections.reverse(cars);

        int winnerCount = cars.get(0).getCount();

        for(Car car : cars) {
            if(car.getCount() == winnerCount) {
                winnerNames.add(car.getName());
            } else {
                break;
            }
        }

        return winnerNames;
    }
}
