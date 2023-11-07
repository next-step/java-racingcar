package racing.ui;

import java.util.Scanner;

public class RacingGameInput {
    public static int askTheNumberOfCar() {
        return question("자동차 대수는 몇 대 인가요?");
    }

    public static int askTheNumberOfCycle() {
        return question("시도할 회수는 몇 회 인가요?");
    }

    private static int question(String questionMessage) {
        System.out.print(questionMessage + ": ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
}
