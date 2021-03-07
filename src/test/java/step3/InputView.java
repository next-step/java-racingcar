package step3;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Rule rule;

    public InputView() {
        this(new Scanner(System.in));
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        this.rule = new Rule(0, 0);
    }

    public void enterCarCount() {
        System.out.println(ViewConstant.ENTER_CAR_COUNT);
        this.rule.setCarCount(scanner.nextInt());
    }

    public void enterMoveCount() {
        System.out.println(ViewConstant.ENTER_MOVE_COUNT);
        this.rule.setMoveCount(scanner.nextInt());
    }

    public int getCarCount() {
        return this.rule.getCarCount();
    }

    public int getMoveCount() {
        return this.rule.getMoveCount();
    }
}