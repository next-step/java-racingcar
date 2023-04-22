package step3.output;

import step3.Car;

import java.util.List;

 public class ResultView {
    public static final String MARK = "-";

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printOneRace(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printOneRace(Car car) {
        for(int j = 0; j< car.getGoCount(); j++){
            System.out.print(MARK);
        }
    }
}
