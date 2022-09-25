package car;

import java.util.List;

public class ResultCarView implements ResultView {
    private static final String OUT_PUT_TEXT = "_ ";

    public void print(List<Car> cars, int tryNum) {
        for (Car car : cars) {
            printCar(car, tryNum);
        }
        System.out.println();
    }

    private void printCar(Car car, int tryNum) {
        for (int i = 0; i <= tryNum; i++) {
            if (car.isMoveAble(i)) {
                System.out.print(OUT_PUT_TEXT);
            }
        }
        System.out.println();
    }
}
