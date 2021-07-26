package race.view;

import race.Condition;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private Condition condition;

    public Condition operate() {
        return input();
    }

    private Condition input() {
        Scanner scanner = new Scanner(System.in);
        out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return Condition.of(carCount, tryCount);
    }

    public InputView() {

    }

    public Condition getCondition() {
        return condition;
    }

}
