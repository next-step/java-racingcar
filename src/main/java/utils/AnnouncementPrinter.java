package utils;

import core.Car;
import core.Cars;
import core.Winners;

import java.util.Arrays;
import java.util.Iterator;

public class AnnouncementPrinter {
    private static final String CAR_NAME_INPUT_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String EMPTY_CAR_NAME_INPUT_ANNOUNCEMENT = "자동차 이름을 최소 1개 이상 입력하세요.";
    private static final String CAR_NAME_INVALID_ANNOUNCEMENT = "자동차 이름은 최대 5자입니다. 다시 입력하세요.";
    private static final String MOVE_COUNT_INPUT_ANNOUNCEMENT = "시도할 회수는 몇회인가요?";
    private static final String MOVE_RESULT_ANNOUNCEMENT = "실행 결과";

    public static void printCarNameInputAnnouncement() {
        System.out.println(CAR_NAME_INPUT_ANNOUNCEMENT);
    }

    public static void printEmptyCarNameInputAnnouncement() {
        System.out.println(EMPTY_CAR_NAME_INPUT_ANNOUNCEMENT);
    }

    public static void printCarNameInvalidAnnouncement() {
        System.out.println(CAR_NAME_INVALID_ANNOUNCEMENT);
    }

    public static void printMoveCountInputAnnouncement() {
        System.out.println(MOVE_COUNT_INPUT_ANNOUNCEMENT);
    }

    public static void printMoveResultAnnouncement() {
        System.out.println(MOVE_RESULT_ANNOUNCEMENT);
    }

    public static void announceWinners(Winners winners) {
        Iterator<Car> iterator = winners.getCars().iterator();
        if (iterator.hasNext()) {
            System.out.print(iterator.next().getCarName());
        }
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next().getCarName());
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getCarName() + " : " + convertCarPositionToString(car));
    }

    public static void printCarsPosition(Cars cars) {
        cars.getCars().forEach(AnnouncementPrinter::printCarPosition);
        System.out.println();
    }

    private static String convertCarPositionToString(Car car) {
        char[] array = new char[car.getPosition()];
        Arrays.fill(array, '-');
        return new String(array);
    }
}
