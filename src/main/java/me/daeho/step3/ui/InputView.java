package me.daeho.step3.ui;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new Scanner(System.in).nextInt();
    }

    public int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new Scanner(System.in).nextInt();
    }
}
