package step3.car_racing.util;

import step3.car_racing.model.Cars;

import java.util.List;

public class WinnerUtil {

    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";
    private static final Integer MIN_DISTANCE = 1;

    private WinnerUtil() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public static String findWinner(Cars cars) {
        StringBuilder winner = new StringBuilder();

        List<String> carNameList = findWinnerCarNameList(cars);

        return winner.append(carNameList).append(WINNER_MESSAGE).toString();
    }

    private static List<String> findWinnerCarNameList(Cars cars) {
        return cars.findWinner();
    }


}
