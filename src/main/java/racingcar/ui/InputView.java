package racingcar.ui;

import racingcar.domain.utils.Number;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getEnterCars() {
        return scanner.next();
    }

    public int getRepeatCount() {
        int repeatCount = scanner.nextInt();
        if (repeatCount < Number.ZERO) {
            throw new IllegalArgumentException("1 이상의 숫자가 필요합니다.");
        }
        return repeatCount;
    }
}
