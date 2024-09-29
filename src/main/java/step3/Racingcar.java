package step3;

import java.util.Scanner;

public class Racingcar {

    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        String car = scanner.nextLine();
        String round = scanner.nextLine();

        validateInput(car, round);

        race(Integer.parseInt(car), Integer.parseInt(round));
    }

    private static void race(int car, int round) {
        PrintView.input(car, round);
    }

    private static void validateInput(String carInput, String roundInput) {
        int car;
        int round;

        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 수 : 올바른 입력값이 아닙니다.");
        }

        if (roundInput == null || roundInput.isEmpty()) {
            throw new IllegalArgumentException("게임 진행 횟수 : 올바른 입력값이 아닙니다.");
        }

        try {
            car = Integer.parseInt(carInput);
            round = Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자(양수)만 입력 가능합니다.");
        }

        if (car < 0 || round < 0) {
            throw new IllegalArgumentException("입력값은 양수만 입력 가능합니다.");
        }
    }
}
