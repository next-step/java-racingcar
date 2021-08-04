package carRacing;

import java.util.Scanner;

public class InputView {

    enum InputType {
        CAR, RACING, NAME
    }

    static Scanner scanner = new Scanner(System.in);

    static void refreshScanner() {
        scanner.next();
    }

    static void printQuestion(InputType type) {
        switch (type) {
            case CAR:
                printNumberOfCars();
                break;
            case RACING:
                printNumberOfRacing();
                break;
            case NAME:
                printCarName();
                break;
        }
    }

    static void printNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    static void printNumberOfRacing() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    static void printCarName() {
        System.out.println("경주할 자동차 이름들을 입력해주세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    static void printNumberError() {
        System.out.println("0 이상의 정수값을 입력해주세요.");
    }

    static void printNamesError() {
        System.out.println("이름은 1자 이상 6자 미만으로 입력해주세요");
    }

    static int inputNumber() {
        return scanner.nextInt();
    }

    static String inputNames() {
        return scanner.nextLine();
    }
}
