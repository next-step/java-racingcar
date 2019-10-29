package winner;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:22
 */
public class CarRaceResultView {

    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    public static void printCurrentCarPosition(Car car) {
        System.out.println(car.showPosition());
    }

    public static void printWinner(String winner) {
        printBlankLine();
        System.out.println(winner + WINNER_TEXT);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
