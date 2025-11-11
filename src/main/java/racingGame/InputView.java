package racingGame;

import java.util.Scanner;

public class InputView {
    
    public static int inputCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputNum();
    }
    
    public static int inputMoveNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputNum();
    }
    
    private static int inputNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
