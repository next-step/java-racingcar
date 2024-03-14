package racingcar.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static InputView instance = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

    public void printNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printNumberOfAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int inputNumberOfCar(Scanner scanner) {
        InputView.getInstance().printNumberOfCar();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수 타입이 아닙니다!" + e);
            throw new RuntimeException();
        }
    }

    public static int inputNumberOfAttempt(Scanner scanner) {
        InputView.getInstance().printNumberOfAttempt();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수 타입이 아닙니다!" + e);
            throw new RuntimeException();
        }
    }

}
