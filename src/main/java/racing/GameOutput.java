package racing;

public class GameOutput {

    private static final String ASK_RACER_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String ROUND_CLOSE = "라운드 종료";
    private static final String COUNT_RACER = "전체 자동차 개수 : ";
    private static final String COUNT_ROUND = "전체 라운드 : ";
    private static final String GO_STRAIGHT_TEXT = "-";

    public void printAskCarCount() {
        System.out.println(ASK_RACER_COUNT);
    }

    public void printAskRoundCount() {
        System.out.println(ASK_ROUND_COUNT);
    }

    public void printCurrentLocation(Car car) {
        System.out.println(GO_STRAIGHT_TEXT.repeat(car.getCurrentLocation()));
    }

    public void printDivideRound() {
        System.out.println(ROUND_CLOSE);
    }

    public void printCarCount(int carCount) {
        System.out.println(COUNT_RACER + carCount);
    }

    public void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }


}
