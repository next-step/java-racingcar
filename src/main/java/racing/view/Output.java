package racing.view;

import racing.domain.Car;

import java.util.List;

public final class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";

    private Output() {
    }

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void count() {
        System.out.println(COUNT_MESSAGE);
    }

    public static void result() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void win(List<String> winnerList) {
        System.out.print("\n" + WIN_MESSAGE);
        System.out.println(String.join(", ", winnerList));
    }

    public static void printCarDistance(List<Car> cars) {
        System.out.println();
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");
            printCarDistance(cars.get(i).getMoveCount());
            System.out.println();
        }
    }

    private static void printCarDistance(int count) {
        for (int j = 0; j < count; j++) {
            System.out.print("-");
        }
    }
}
