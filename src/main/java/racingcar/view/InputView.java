package racingcar.view;

import java.util.Scanner;

public class InputView {
    int number;
    int count;

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int number = scanner.nextInt();
        this.number = number;

        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();
        this.count = count;
    }

    public int getNumber() {
        return this.number;
    }

    public int getCount() {
        return this.count;
    }
}
