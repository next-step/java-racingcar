package racing.view;

import racing.model.Car;
import racing.model.Cars;
import racing.util.StringUtil;

import java.util.List;

public class GameOutput {

    private static final String ROUND_CLOSE = "라운드 종료";
    private static final String COUNT_ROUND = "전체 라운드 : ";
    private static final String RACE_RESULT = "레이스결과";
    private static final String NOTICE_WINNER = "가 최종 우승했습니다.";
    private static final String GO_STRAIGHT_TEXT = "-";
    private static final String COLON = " : ";

    public static void printRoundResultCurrentLocationAndCarName(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + COLON + GO_STRAIGHT_TEXT.repeat(car.getCurrentLocation()));
        }
        System.out.println(ROUND_CLOSE);
    }

    public static void printCarCount(Cars cars) {
        System.out.println(StringUtil.getNameInCarList(cars.getCarList()));
    }

    public static void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }

    public static void printStartRace() {
        System.out.println(RACE_RESULT);
    }

    public static void printNoticeWinner(Cars cars) {
        String winner = StringUtil.getNameInCarList(cars.getCarList());
        System.out.println(winner + NOTICE_WINNER);
    }

}
