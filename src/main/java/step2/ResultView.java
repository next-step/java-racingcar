package step2;

import java.util.List;

public class ResultView {
    private static final String POSITION = "-";
    private static final String COMMA = ",";

    public static void printStartMessage(String[] carNames) {
        System.out.println("실행 결과");
        for (String carName : carNames) {
            printCarInfo(carName);
        }
        newLine();
    }

    public static void print(Cars cars) {
        List<Car> carCollection = cars.getCars();

        for (Car car : carCollection) {
            iteratePrint(car);
            newLine();
        }
        newLine();
    }

    public static void printWinner(List<String> winners) {
        int winnerSize = winners.size();

        for (int i = 0; i < winnerSize; i++) {
            System.out.print(winners.get(i));
            printComma(i, winnerSize);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printComma(int index, int maxSize) {
        if (index < maxSize - 1) {
            System.out.print(COMMA);
        }
    }

    private static void printCarInfo(String carName) {
        System.out.println(carName + " : " + POSITION);
    }

    private static void iteratePrint(Car car) {
        int movedPosition = car.getPosition();
        printCarName(car.getName());

        for (int i = 0; i < movedPosition; i++) {
            System.out.print(POSITION);
        }
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void newLine() {
        System.out.println();
    }
}
