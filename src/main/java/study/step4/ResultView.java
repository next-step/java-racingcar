package study.step4;

public class ResultView {
    /* 메시지 출력 */
    public static void printMessage(String message) {
        System.out.print(message);
    }

    /* 메시지 개행 출력 */
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    /* 개행 */
    public static void printCrlf() {
        printlnMessage("");
    }

    /* 점수만큼 출력 */
    public static void printScore(Car car) {
        for (int i = 0; i < car.getScore(); i++) {
            printForwardLine();
        }
    }

    /* 전진 */
    public static void printForwardLine() {
        printMessage("-");
    }

    /* 우승자 출력 */
    public static void printWinner(Cars cars) {
        printMessage(String.join(",", cars.getWinnerNames()) + "가 최종 우승했습니다.");
    }
}
