package racingcar.view;

import java.util.Scanner;

public class InputView {
    public final int CAR_COUNT;
    public final int TRY_COUNT;
    private final static Scanner scanner = new Scanner(System.in);

    public InputView() {
        CAR_COUNT = setCarCount();
        TRY_COUNT = setTryCount();
    }

    private int setTryCount() {
        ResultView.printTryCountQuestion();
        int tryCount = scanner.nextInt();
        if(isValid(tryCount))   return tryCount;
        return 0;
    }

    private int setCarCount() {
        ResultView.printCarCountQuestion();
        int carCount = scanner.nextInt();
        if(isValid(carCount))   return carCount;
        return 0;
    }

    private boolean isValid(int carCount) {
        if(carCount > 0)    return true;
        throw new IllegalArgumentException("0이하의 수를 입력하면 게임을 진행할 수 없습니다.");
    }



}
