package racing.ui;

import java.util.Scanner;

public class RacingGameInput {
    public static int askTheNumberOfCar() {
        return intQuestion("자동차 대수는 몇 대 인가요?");
    }

    public static int askTheNumberOfCycle() {
        return intQuestion("시도할 회수는 몇 회 인가요?");
    }

    public static String askNamesOfCars() {
        return stringQuestion("자동차들의 이름을 입력하세요.");
    }

    private static int intQuestion(String questionMessage) {
        System.out.print(questionMessage + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String stringQuestion(String questionMessage) {
        System.out.print(questionMessage + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
