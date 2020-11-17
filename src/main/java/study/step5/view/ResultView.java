package study.step5.view;

import study.step5.domain.Car;
import study.step5.domain.Cars;

public class ResultView {
    /* 자동차 목록 점수만큼 출력 */
    public static void printCarsScore(Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);
            printMessage(car.getName() + " : ");
            printScore(car);
            printCrlf();
        }
        printCrlf();
    }

    /* 메시지 출력 */
    public static void printMessage(String message) {
        System.out.print(message);
    }

    /* 개행 */
    public static void printCrlf() {
        printlnMessage("");
    }

    /* 메시지 개행 출력 */
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    /* 점수만큼 출력 */
    private static void printScore(Car car) {
        for (int i = 0; i < car.getScore(); i++) {
            printForwardLine();
        }
    }

    /* 전진 */
    private static void printForwardLine() {
        printMessage("-");
    }

    /* 우승자 출력 */
    public static void printWinner(Cars cars) {
        String[] winnerNames = cars
                .getWinners()
                .stream()
                .map(winner -> winner.getName())
                .toArray(String[]::new);
        printMessage(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
