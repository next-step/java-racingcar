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

    public void printNamesOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printNumberOfAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static String inputNamesOfCar(Scanner scanner) {
        InputView.getInstance().printNamesOfCar();
        return scanner.next();
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
