package carRacing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    final static String DELIMITER = ",";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getStringInput();
    }

    public int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return getIntInput();
    }

    private String getStringInput() {
        String carNames;
        try {
            carNames = scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효한 자동차 이름을 입력하세요.");
        }
        return carNames;
    }

    private int getIntInput() {
        int count;
        try {
            count = scanner.nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
        return count;
    }


}
