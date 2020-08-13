package racing.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int howManyCars() {
        return getNumber("자동차 대수는 몇 대 인가요?");
    }

    public int howManyTrials() {
        return getNumber("시도할 회수는 몇 회 인가요?");
    }

    private int getNumber(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }
}
