package racing;


import java.util.List;
import java.util.StringJoiner;

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
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static void printWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(", ", "", "가 최종 우승했습니다.");

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }
        System.out.print(joiner.toString());
    }
}
