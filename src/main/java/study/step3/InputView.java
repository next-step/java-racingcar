package study.step3;

import java.util.Scanner;

public class InputView {

    public static Rule loadRule() {
        return new Rule(howManyCar(), howManyTimes());
    }

    private static int howManyCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private static int howManyTimes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회 인가요?");
        return scanner.nextInt();
    }
}
