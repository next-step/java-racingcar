package racing.view;

import racing.Constant;
import racing.domain.Car;

import java.util.List;

public class ResultView {

    public static void printRaceResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
    }

    public static void printCarPosition(Car car){
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Constant.MARK);
        }
    }
}
