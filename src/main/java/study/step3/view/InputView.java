package study.step3.view;

import study.step3.model.view.Input;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public Input getUserInput() {
        return new Input(getCarNumber(), getRacingGameRound());
    }

    public int getCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getRacingGameRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
