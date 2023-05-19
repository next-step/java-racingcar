package study.step3;

import study.step3.domain.Car;

import java.util.List;

public class ResultView {
    private static final char POSITION_MARK = '*';
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getPositionStr(car));
        }
        System.out.println();

    }
    private String getPositionStr(Car car) {
        StringBuilder positionStr = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            positionStr.append(POSITION_MARK);
        }
        return positionStr.toString();

    }

}
