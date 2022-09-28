package Service;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private int attempts;
    private String[] carNames;

    public void inputCarInfo() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine().split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scanner.nextInt();
    }

    public int getAttempts() {
        return attempts;
    }
    public String[] getCarNames() {
        return carNames;
    }
}
