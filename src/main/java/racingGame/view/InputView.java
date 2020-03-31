package racingGame.view;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static int rounds;
    private static String[] cars;

    public static String[] cars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return inputCarsValidator();
    }

    public static int rounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputRoundValidator();
    }

    public static String[] inputCarsValidator() {
        String carsName = scanner.nextLine();
        cars = carsName.trim().split(",");
        if (Objects.isNull(carsName) || "".equals(carsName)) {
            System.out.println("1대 이상 입력해주세요.");
            cars();
        }
        return cars;
    }

    public static int inputRoundValidator() {
        try {
            rounds = isGreaterThan0(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력가능합니다.");
            rounds();
        }
        return rounds;
    }

    public static int isGreaterThan0(int rounds) {
        if (rounds < 1) {
            System.out.println("1이상의 숫자를 입력해 주세요");
            rounds();
        }
        return rounds;
    }
}
