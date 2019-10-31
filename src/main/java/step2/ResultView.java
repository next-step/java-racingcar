package step2;

import java.util.List;

public class ResultView {
    private static final String POSITION = "-";
    private static final String COMMA = ",";
    private static final String START_MESSAGE = "실행 결과";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";

    public static void printStartMessage(String[] carNames) {
        System.out.println(START_MESSAGE);
        for (String carName : carNames) {
            System.out.println(carName + " : " + POSITION);
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

    private static void iteratePrint(Car car) {
        int movedPosition = car.getPosition();
        printCarName(car.getName());

        for (int i = 0; i < movedPosition; i++) {
            System.out.print(POSITION);
        }
    }

    private static void newLine() {
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        int winnerSize = winners.size();

        for (int i = 0; i < winnerSize; i++) {
            System.out.print(winners.get(i));
            printComma(i, winnerSize);
        }
        System.out.println(END_MESSAGE);
    }

    private static void printComma(int index, int maxSize) {
        if (!isLastCar(index, maxSize)) {
            System.out.print(COMMA);
        }
    }

    private static boolean isLastCar(int index, int maxSize) {
        return index < maxSize - 1;
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }
}
