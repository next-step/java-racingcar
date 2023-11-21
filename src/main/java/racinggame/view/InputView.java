package racinggame.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String printRequestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int printRequestGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int gameCount = scanner.nextInt();
            checkGameCount(gameCount);
            return gameCount;
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void checkGameCount(int gameCount) {
        if(gameCount < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }else if(gameCount >= 10){
            throw new IllegalArgumentException("게임 시도 횟수는 최대 10번만 가능합니다.");
        }

    }
}
