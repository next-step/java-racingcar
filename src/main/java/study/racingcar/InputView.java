package study.racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    /**
     * 입력을 담당한다. (입력에 대한 검증 책임 있음)
     */
    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumber() {
        int carNum = getNumber();
        validateIfIsGreaterThanZero(carNum);
        return carNum;
    }

    public int getTryCount() {
        int tryCount = getNumber();
        validateIfIsGreaterThanZero(tryCount);
        return tryCount;
    }

    private void validateIfIsGreaterThanZero(int carNum) {
        if (carNum <= 0) {
            throw new IllegalArgumentException("1보다 큰 수를 입력하세요");
        }
    }

    private int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}