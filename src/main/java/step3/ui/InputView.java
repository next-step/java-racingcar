package step3.ui;

import step3.domain.Input;

import java.util.Scanner;

public class InputView {
    public static Input raceStartBroadcast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int value = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();
        return Input.of(value, number);
    }
}
