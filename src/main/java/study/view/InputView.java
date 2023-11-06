package study.view;

import java.util.Scanner;

public class InputView {
    public int setNumberOfCars() {
        Scanner scanner = getScanner();
        System.out.println("자동차 대수는 몇 대 인가요?");
        int inputValue = scanner.nextInt();
        return inputValue;
    }

    public int setNumberOfMoves() {
        Scanner scanner = getScanner();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int inputValue = scanner.nextInt();
        return inputValue;
    }

    private static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
