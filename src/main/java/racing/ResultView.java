package racing;

import java.util.List;

public class ResultView {

    private static final String ENTER = "\n";

    public static void printCarDistance(List<Car> cars) {
        for (Car car : cars) {
            car.printName();
            System.out.print(" : ");
            car.printDistance();
            System.out.print(ENTER);
        }
        System.out.print(ENTER);
    }

    public static void printWinner(List<Car> winners) {

        for (int i = 0; i < winners.size(); i++) {
            winners.get(i).printName();
            printCommaExceptLastElement(winners, i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printCommaExceptLastElement(List<Car> winners, int i) {
        if (i != winners.size() - 1) {
            System.out.print(", ");
        }
    }

    public static void printHeader() {
        System.out.println("실행 결과");
    }
}
