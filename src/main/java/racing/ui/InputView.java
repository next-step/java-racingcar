package racing.ui;

import racing.domain.Competition;

import java.util.Scanner;

public class InputView {
    public static Competition input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대인가요?");
        int unit = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        int count = scanner.nextInt();

        return new Competition(unit, count);
    }
}
