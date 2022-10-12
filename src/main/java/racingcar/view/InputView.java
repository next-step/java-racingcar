package racingcar.view;

import calculator.Positive;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static String[] requestInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");

        String[] names = scanString().split(",");
        for (String name: names) {
            validateName(name);
        }

        return names;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int requestInputRepeat() {
        return requestPositiveNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int requestPositiveNumber(String message) {
        System.out.println(message);
        int number = 0;

        try {
            number = new Positive(scanNumber()).get();
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("0 이상의 숫자를 입력해야 합니다.");
            System.exit(1);
        }

        System.out.println();
        return number;
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
