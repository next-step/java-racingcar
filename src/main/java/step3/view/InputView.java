package step3.view;

import step3.utils.InputValidator;

import java.util.Scanner;

public class InputView {

    private static int numberOfAttemps;
    private static String symbol;
    private static String[] carNames;

    public static void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputCarNames = scan.next();
        carNames = InputValidator.validateCarName(inputCarNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        numberOfAttemps = scan.nextInt();

        System.out.println("경주 결과에 사용할 심볼을 입력해주세요.");
        String inputSymbol = scan.next();
        symbol = InputValidator.validateSymbol(inputSymbol);
    }

    public static String[] getCarNames() {
        return carNames;
    }

    public static int getNumberOfAttemps() {
        return numberOfAttemps;
    }

    public static String getSymbol() {
        return symbol;
    }
}
