package racing;

import java.util.Scanner;

public class InputView {

    static int InputCountOfUnit() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String unit = scanner.nextLine();
        System.out.println("scanner.nextInt() = " + scanner.nextInt());
        return scanner.nextInt();
    }

    static int InputCountOfTurn() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        String unit = scanner.nextLine();
        System.out.println("scanner.nextInt() = " + scanner.nextInt());
        return scanner.nextInt();
    }
}
