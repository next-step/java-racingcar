package study.racing.view;

import study.racing.domain.RaceInput;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static RaceInput raceInput() {
        System.out.println("경주할 자동자 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = namesInput();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempt = numberInput();
        System.out.println();

        return new RaceInput(names, numberOfAttempt);
    }

    private static List<String> namesInput() {
        while (true) {
            String names = scanner.next();
            if (!names.isBlank()) {
                return Arrays.asList(names.split(","));
            }
            System.out.println("입력 값으로 공백은 허용되지 않습니다.");
            System.out.println("------------------------------------");
        }
    }

    public static int numberInput() {
        while (true) {
            try {
                int number = scanner.nextInt();
                checkNumber(number);
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                System.out.println("------------------------------------");
                scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.println("입력 값은 0보다 커야 합니다. 다시 입력해주세요.");
                System.out.println("------------------------------------");
            }
        }
    }

    private static void checkNumber(int number) {
        if (number < 1) {
            throw new RuntimeException();
        }
    }
}
