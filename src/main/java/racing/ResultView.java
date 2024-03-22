package racing;


import java.util.List;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("static method class");
    }

    static void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarResult(car);
        }
    }

    static void printCarResult(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
