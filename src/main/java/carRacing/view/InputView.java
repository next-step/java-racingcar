package carRacing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getCarCount() {
        System.out.println("자동차의 대수는 몇 대 인가요?");
        return getIntInput();
    }

    public int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return getIntInput();
    }

    private int getIntInput() {
        int count;
        try {
            count = scanner.nextInt();
            if(count <= 0)
                throw new IllegalArgumentException("유효한 양의 정수를 입력하세요");
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
        return count;
    }

}
