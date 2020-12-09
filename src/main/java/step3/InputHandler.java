package step3;

import step2.MathematicalExpression;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String text = scanner.nextLine();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return getCarCount();
        }
    }

    public int getRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String text = scanner.nextLine();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return getRoundCount();
        }
    }

}
