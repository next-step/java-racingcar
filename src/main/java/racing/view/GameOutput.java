package racing.view;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class GameOutput {

    private static final String ROUND_CLOSE = "라운드 종료";
    private static final String COUNT_ROUND = "전체 라운드 : ";
    private static final String RACE_RESULT = "레이스결과";
    private static final String NOTICE_WINNER = "가 최종 우승했습니다.";
    private static final String GO_STRAIGHT_TEXT = "-";
    private static final String COLON = " : ";

    public static void printCurrentLocationAndCarName(Car car) {
        System.out.println(car.getName() + COLON + GO_STRAIGHT_TEXT.repeat(car.getCurrentLocation()));
    }

    public static void printDivideRound() {
        System.out.println(ROUND_CLOSE);
    }

    public static void printCarCount(Cars cars) {
        System.out.println(cars.getNameInCarList());
    }

    public static void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }

    public static void printStartRace() {
        System.out.println(RACE_RESULT);
    }

    public static void printNoticeWinner(Cars cars) {
        String winner = cars.getNameInCarList();
        System.out.println(winner + NOTICE_WINNER);
    }

}
