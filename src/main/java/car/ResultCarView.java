package car;

import java.util.List;

public class ResultCarView implements ResultView<Car> {
    public void print(List<Car> cars, int tryNum) {
        System.out.println("실행결과");
        for (int i = 0; i < tryNum; i++) {
            printRacing(cars);
            System.out.println();
        }
    }

    private void printRacing(List<Car> cars) {
        for (Car car : cars) {
            car.racing();
            System.out.println(car.printResult());
        }
    }
}
