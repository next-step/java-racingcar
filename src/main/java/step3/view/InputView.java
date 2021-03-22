package step3.view;

import java.util.Scanner;

public class InputView {

    private static int numberOfCars;
    private static int numberOfAttemps;
    private static String symbol;

    public static void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        numberOfCars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        numberOfAttemps = scan.nextInt();

        System.out.println("경주 결과에 사용할 심볼을 입력해주세요.");
        symbol = scan.next();
        while (symbol.getBytes().length != 1) {
            System.out.println("한 바이트로 입력해주세요.");
            symbol = scan.next();
        }
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public static int getNumberOfAttemps() {
        return numberOfAttemps;
    }

    public static String getSymbol() {
        return symbol;
    }
}
