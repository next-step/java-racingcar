package racingGame;

import java.util.Scanner;

public class InputView {
    
    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return inputString();
    }
    
    public static int inputMoveNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputNum();
    }
    
    private static int inputNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String[] inputString() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name.split(",");
    }
}
