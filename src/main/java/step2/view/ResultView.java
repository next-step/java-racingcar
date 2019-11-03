package step2.view;

import step2.domain.Car;
import step2.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String POSITION = "-";
    private static final String COMMA_AND_SPACE = ", ";
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
        String mergedWinner = String.join(COMMA_AND_SPACE, winners);
        System.out.println(mergedWinner + END_MESSAGE);
    }

    private static boolean isCommaNeed(int index, int maxSize) {
        return index < (maxSize - 1);
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }
}
