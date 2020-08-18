package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getNamesOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(DELIMITER);
    }

    public int getNumberOfTrials() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
