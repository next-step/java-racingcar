package racing;

import java.util.List;

public class Printer {

    static public void printStartRacing() {
        print("\n실행 결과");
    }

    static public void printResult(List<Car> cars) {
        for (Car car : cars) {
            print(car.getMovesRoad());
        }

        print("");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
