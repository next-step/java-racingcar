package racing.view;

import racing.model.Car;

import java.util.List;

public class GameOutput {

    private static final String ROUND_CLOSE = "라운드 종료";
    private static final String COUNT_ROUND = "전체 라운드 : ";
    private static final String RACE_RESULT = "레이스결과";
    private static final String NOTICE_WINNER = "가 최종 우승했습니다.";
    private static final String GO_STRAIGHT_TEXT = "-";
    private static final String COMMA = ",";
    private static final String REMOVE_LAST_COMMA_REGEX = ",$";
    private static final String BLANK = "";
    private static final String COLON = " : ";

    public void printCurrentLocationAndCarName(Car car) {
        System.out.println(car.getName() + COLON + GO_STRAIGHT_TEXT.repeat(car.getCurrentLocation()));
    }

    public void printDivideRound() {
        System.out.println(ROUND_CLOSE);
    }

    public void printCarCount(List<Car> cars) {
        System.out.println(getNameInCarList(cars));
    }

    public void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }

    public void printRaceResult() {
        System.out.println(RACE_RESULT);
    }

    public void printNoticeWinner(List<Car> cars) {
        String winner = getNameInCarList(cars);
        System.out.println(winner + NOTICE_WINNER);
    }

    public String getNameInCarList(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(COMMA);
        }
        return removeComma(sb.toString());
    }

    private String removeComma(String string) {
        return string.replaceAll(REMOVE_LAST_COMMA_REGEX, BLANK);
    }
}
