package racinggame.view;

import racinggame.common.constants.RexFormatConstants;
import racinggame.common.util.PrintUtils;
import racinggame.vo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_TEXT = "실행 결과";
    private static final String RESULT_WINNER_TEXT = "가 최종 우승했습니다.";
    private static final StringBuffer sb = new StringBuffer();
    private static final String LAST_COMMA_REMOVE_REX_FORMAT_TEXT = ",$";
    private static int winnerMoveCount = 0;
    private static List<Car> winnerCarList = new ArrayList<>();

    public static void resultMessagePrint() {
        PrintUtils.println(RESULT_TEXT);
    }

    public static void resultPrint(Map<Integer, Car> carMap) {

        for (Integer carNumber : carMap.keySet()) {
            Car car = carMap.get(carNumber);
            sb.append(car.getName()).append(" : ").append("-".repeat(Math.max(0, car.getMoveCount())));
            PrintUtils.println(sb.toString());
            clearStringBuffer();
        }
        PrintUtils.println("");

    }

    public static void winnerPrint(Map<Integer, Car> carMap) {
        PrintUtils.println(getWinner(carMap) + RESULT_WINNER_TEXT);
    }

    public static String getWinner(Map<Integer, Car> carMap) {
        for (Integer carNumber : carMap.keySet()) {
            Car car = carMap.get(carNumber);
            addWinner(car);
        }
        StringBuilder sb = new StringBuilder();
        for (Car car : winnerCarList) {
            sb.append(car.getName()).append(RexFormatConstants.CARS_NAME_REX_FORMAT_TEXT.getValue());
        }
        return sb.toString().replaceAll(LAST_COMMA_REMOVE_REX_FORMAT_TEXT, "");
    }

    private static void addWinner(Car car) {
        if (car.getMoveCount() > winnerMoveCount) {
            winnerMoveCount = car.getMoveCount();
            winnerCarList.clear();
            addWinnerCarList(car);
        }
        if (car.getMoveCount() == winnerMoveCount) {
            addWinnerCarList(car);
        }
    }

    private static void addWinnerCarList(Car car) {
        if (!winnerCarList.contains(car)) winnerCarList.add(car);
    }

    private static void clearStringBuffer() {
        sb.setLength(0);
    }

}
