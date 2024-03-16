package racing.view;

import racing.Constant;
import racing.domain.Car;

import java.util.List;

public class ResultView {

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printCarPosition(Car car){
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(Constant.MARK);
        }
        System.out.println(sb);
    }
}
