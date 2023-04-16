package racing;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_GRAPH = "-";
    private static final String ENTER = "\n";

    public static void printCarDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + repeatString(DISTANCE_GRAPH, car.getPosition()));
        }
        System.out.print(ENTER);
    }

    public static void printWinner(List<Car> winners) {

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
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

    private static String repeatString(String str, long num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
