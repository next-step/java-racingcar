package study.racing.ui;

import study.racing.model.Car;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final char CAR_MOVED = '-';

    public void printCarPositions(List<Car> cars) {
        for(Car car : cars) {
            char[] chars = new char[car.getCount()];
            Arrays.fill(chars, CAR_MOVED);

            System.out.println(chars);
        }

        System.out.println();
    }


}
