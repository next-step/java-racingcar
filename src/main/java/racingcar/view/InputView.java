package racingcar.view;

import racingcar.Constants;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int carNumber;
    public int round;

    public void input() {
        inputCarNumber();
        inputRound();
    }

    private void inputCarNumber() {
        System.out.println(Constants.INPUT_CAR_NUMBER_COMMANDS);
        setCarNumber(scanner.nextInt());
    }

    private void inputRound() {
        System.out.println(Constants.INPUT_ROUND_NUMBER_COMMANDS);
        setRound(scanner.nextInt());
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getRound() {
        return round;
    }
}
