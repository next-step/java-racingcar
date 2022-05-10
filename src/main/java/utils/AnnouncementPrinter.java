package utils;

import core.Car;
import core.Cars;
import core.PositionBoard;
import core.Winners;

import java.util.Arrays;

public class AnnouncementPrinter {
    public static final String CAR_NAME_INPUT_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String EMPTY_CAR_NAME_INPUT_ANNOUNCEMENT = "자동차 이름을 최소 1개 이상 입력하세요.";
    public static final String CAR_NAME_INVALID_ANNOUNCEMENT = "자동차 이름은 최대 5자입니다. 다시 입력하세요.";
    public static final String MOVE_COUNT_INPUT_ANNOUNCEMENT = "시도할 회수는 몇회인가요?";
    public static final String MOVE_RESULT_ANNOUNCEMENT = "실행 결과";

    public static void printCarNameInputAnnouncement() {
        System.out.println(CAR_NAME_INPUT_ANNOUNCEMENT);
    }

    public static void printEmptyCarNameInputAnnouncement() {
        System.out.println(EMPTY_CAR_NAME_INPUT_ANNOUNCEMENT);
    }

    public static void printMoveCountInputAnnouncement() {
        System.out.println(MOVE_COUNT_INPUT_ANNOUNCEMENT);
    }

    public static void printMoveResult(Cars cars, PositionBoard positionBoard, int moveCount) {
        System.out.println(MOVE_RESULT_ANNOUNCEMENT);
        for (int i = 0; i < moveCount; i++) {
            printCarsPositionAtTurn(cars, positionBoard, i);
        }
    }

    public static void announceWinners(Winners winners) {
        System.out.println(String.join(", ", winners.namesAsString()) + "가 최종 우승했습니다.");
    }

    private static void printCarPositionAtTurn(Car car, PositionBoard positionBoard, int turn) {
        System.out.println(car.getCarName() + " : "
                + convertCarPositionToString(positionBoard.getPositionAtTurn(car, turn)));
    }

    private static void printCarsPositionAtTurn(Cars cars, PositionBoard positionBoard, int turn) {
        cars.getCars().forEach(car -> AnnouncementPrinter.printCarPositionAtTurn(car, positionBoard, turn));
        System.out.println();
    }

    private static String convertCarPositionToString(int position) {
        char[] array = new char[position];
        Arrays.fill(array, '-');
        return new String(array);
    }
}
