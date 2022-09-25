package racing.view;

import racing.model.Car;

public class GameOutput {

    private static final String ROUND_CLOSE = "라운드 종료";
    private static final String COUNT_CAR = "전체 자동차 개수 : ";
    private static final String COUNT_ROUND = "전체 라운드 : ";
    private static final String GO_STRAIGHT_TEXT = "-";

    public void printCurrentLocation(Car car) {
        System.out.println(GO_STRAIGHT_TEXT.repeat(car.getCurrentLocation()));
    }

    public void printDivideRound() {
        System.out.println(ROUND_CLOSE);
    }

    public void printCarCount(int carCount) {
        System.out.println(COUNT_CAR + carCount);
    }

    public void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }


}
