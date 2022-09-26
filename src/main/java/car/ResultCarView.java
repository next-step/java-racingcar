package car;

import java.util.List;

public class ResultCarView implements ResultView {
    public void print(List<Car> cars, int tryNum) {
        System.out.println("실행결과");
        for (int i = 0; i < tryNum; i++) {
            printRacing(cars, i);
            System.out.println();
        }
    }

    private void printRacing(List<Car> cars, int stage) {
        for (Car car : cars) {
            car.racing();
            car.printResult();
        }
    }
}
