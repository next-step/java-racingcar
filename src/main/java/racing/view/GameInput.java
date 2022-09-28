package racing.view;

import java.util.Scanner;

import static util.NumberUtils.notPositive;


public class GameInput {
    private final static Scanner SCANNER = new Scanner(System.in);
    private int count = 0;

    public int inputCarCount() {
        System.out.println("자동차의 수는 몇 대 인가요?");
        inputCount();

        return count;
    }

    public int inputMoveCount() {
        System.out.println("앞으로 몇 번을 이동하시겠습니까?");
        inputCount();

        return count;
    }

    private void inputCount() {
        count = SCANNER.nextInt();
        while (notPositive(count)) {
            System.out.println("양수만 입력 가능합니다.");
            count = SCANNER.nextInt();
        }
    }
}