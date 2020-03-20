package racingcar;

import racingcar.car.Car;

import java.util.List;

public class ResultView {
    public void print(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private void printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append('-');
        }
        System.out.println(stringBuilder.toString());
    }
}
