package step3;

import java.util.Scanner;

public class InputView {
    private int carsCount;
    private int roundsCount;
    private String[] carsName;
    private Scanner scanner;

    public InputView() {
        carsCount = 0;
        roundsCount = 0;
        scanner = new Scanner(System.in);
    }

    public int getRoundsCount() {
        return this.roundsCount;
    }

    public String[] getCarsName() {
        return this.carsName;
    }

    public void inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carsName = StringUtil.split(",", scanner.next());
    }

    public void inputRoundsCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.roundsCount = scanner.nextInt();
    }
}
