package racingcar;

import java.util.List;

public class OutputView {

    public static void printMileage(List<Car> cars, int times) {
        System.out.println("샐행 결과");
        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                System.out.println(car.getMileageOfNthRun(i));
            }
            System.out.println();
        }
    }
}
