package racing.view;

import java.util.Scanner;


public class GameInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private int count;

    public int inputCarCount() {
        System.out.println("자동차의 수는 몇 대 인가요?");
        inputCount();

        return count;
    }

    public int inputTryCount() {
        System.out.println("앞으로 몇 번을 이동하시겠습니까?");
        inputCount();

        return count;
    }

    private void inputCount() {
        count = SCANNER.nextInt();
        while (notPositiveCount()) {
            System.out.println("양수만 입력 가능합니다.");
            count = SCANNER.nextInt();
        }
    }

    private boolean notPositiveCount() {
        if (count < 1) {
            return true;
        }
        return false;
    }
}
