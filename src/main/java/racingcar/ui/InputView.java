package racingcar.ui;

import racingcar.domain.RacingGameConstant;

import java.util.Scanner;

public class InputView {

    private int numberOfCars;
    private int time;

    public InputView() {
        this.numberOfCars = requestTotalCarCount();
        this.time = requestTime();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTime() {
        return time;
    }

    private int requestTotalCarCount() {
        System.out.println(RacingGameConstant.REQUEST_CAR_COUNT_MESSAGE);
        return scan();
    }

    private int requestTime() {
        System.out.println(RacingGameConstant.REQUEST_TRY_TIME_MESSAGE);
        return scan();
    }

    private int scan() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RacingGameConstant.IS_NOT_A_NUMBER);
        }
    }

}
