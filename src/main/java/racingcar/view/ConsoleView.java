package racingcar.view;

import racingcar.PositiveNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleView {
    private static final int INVALID_INPUT_LIMIT = 3;

    public void printCarLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public int numbOfCar() {
        return tryPrintAndGet(this::printAndGetNumbOfCar);
    }

    public int numbOfTrial() {
        return tryPrintAndGet(this::printAndGetNumbOfTrial);
    }

    private int tryPrintAndGet(Supplier<Integer> printAndGetInput) {
        int numbOfInput = 0;

        while (numbOfInput < INVALID_INPUT_LIMIT) {
            numbOfInput++;

            try {
                return printAndGetInput.get();
            } catch (PositiveNumberException ex) {
                System.out.println("양수인 정수를 입력해 주세요");
            }
        }

        throw new RuntimeException("유효하지 않은 입력 횟수 를 초과했습니다");
    }

    private int printAndGetNumbOfTrial() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return tryGetInteger();
    }

    private int printAndGetNumbOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return tryGetInteger();
    }

    private int tryGetInteger() {
        try {
            return getPositiveNumberInput();
        } catch (InputMismatchException ex) {
            throw new PositiveNumberException(ex);
        }
    }

    private int getPositiveNumberInput() {
        Scanner scanner = new Scanner(System.in);

        int numb = scanner.nextInt();

        if (numb < 0) {
            throw new PositiveNumberException("양수가 아닙니다");
        }

        return numb;
    }
}
