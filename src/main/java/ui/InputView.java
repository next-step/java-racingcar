package ui;

import java.util.Scanner;

public class InputView {

    public static int getCarSize() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getNumber();
    }

    public static int getTurn() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getNumber();
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
