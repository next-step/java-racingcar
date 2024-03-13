package racing.view;

import racing.Constant;
import racing.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printCarPosition(Car car){
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, car.getPosition()).forEach(i -> sb.append(Constant.MARK));
        System.out.println(sb);
    }
}
