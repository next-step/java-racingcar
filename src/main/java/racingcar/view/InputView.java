package racingcar.view;

import racingcar.Constants;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int carNumber;
    public int round;

    public void input() {
        getCarNumber();
        getRound();
    }

    private void getCarNumber() {
        System.out.println(Constants.INPUT_CAR_NUMBER_COMMANDS);
        setCarNumber(scanner.nextInt());
    }

    private void getRound() {
        System.out.println(Constants.INPUT_ROUND_NUMBER_COMMANDS);
        setRound(scanner.nextInt());
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
