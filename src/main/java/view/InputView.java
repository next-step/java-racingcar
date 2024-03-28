package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public void requestEntry() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void requestTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public int inputIntData() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 숫자만 입력하세요");
        }
    }

    public String inputStringData() {
        return scanner.nextLine();
    }
}