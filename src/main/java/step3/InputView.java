package step3;

import java.util.Scanner;

public class InputView {
    private final String Q_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private final String Q_TRY_TIMES = "시도할 회수는 몇 회 인가요?";
    Scanner scanner = new Scanner(System.in);

    public void printQ_CarNumber() {
        System.out.println(Q_CAR_NUMBER);
    }

    public void printQ_TryTimes() {
        System.out.println(Q_TRY_TIMES);
    }

    public int inputNumber() {
        return scanner.nextInt();
    }

    public String inputString() {
        return scanner.nextLine();
    }
}
