package carRacing;

import java.util.Scanner;

public class InputView {

    enum InputType {
        CAR, RACING
    }

    static Scanner scanner = new Scanner(System.in);

    static void printNumberQuestion(InputType type) {
        switch (type) {
            case CAR:
                printNumberOfCars();
                break;
            case RACING:
                printNumberOfRacing();
                break;
        }
    }

    static void printNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    static void printNumberOfRacing() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    static void printError() {
        System.out.println("0 이상의 정수값을 입력해주세요.");
    }

    static int inputNumber() {
        return scanner.nextInt();
    }
}
