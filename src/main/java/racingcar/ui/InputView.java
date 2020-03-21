package racingcar.ui;

import racingcar.Constant;

import java.util.Scanner;

public class InputView {

    private int totalCarCount;
    private int time;

    public InputView() {
        this.totalCarCount = requestTotalCarCount();
        this.time = requestTime();
    }

    public int getTotalCarCount() {
        return totalCarCount;
    }

    public int getTime() {
        return time;
    }

    private int requestTotalCarCount() {
        System.out.println(Constant.REQUEST_CAR_COUNT_MESSAGE);
        return scan();
    }

    private int requestTime() {
        System.out.println(Constant.REQUEST_TRY_TIME_MESSAGE);
        return scan();
    }

    private int scan() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.IS_NOT_A_NUMBER);
        }
    }

}
