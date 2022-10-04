package third.view;

import third.logic.Car;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ResultView {

    public static void printOneRace(ArrayList<Car> carList) {
        for (Car car : carList) {
            printCarLocation(car.getCarLocation());
        }
        System.out.println();
    }

    public static void printCarLocation(int carLocation) {
        IntStream.range(0, carLocation).mapToObj(i -> "-").forEach(System.out::print);
        System.out.println();
    }

    public static void printResultLine() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
