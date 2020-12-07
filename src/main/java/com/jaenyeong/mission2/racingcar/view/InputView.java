package com.jaenyeong.mission2.racingcar.view;

import java.util.Scanner;

public class InputView implements Input {
    final Output output;
    final Scanner scanner;

    public InputView(final Output output) {
        this.output = output;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int inputHowManyUseCars() {
        return inputUntilCorrectIntType();
    }

    private int inputUntilCorrectIntType() {
        int input = CAN_NOT_READ;
        do {
            input = inputIntValue();

        } while (input == CAN_NOT_READ);

        return input;
    }

    private int inputIntValue() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            printErrorMessage();
            scanner.next();
            return CAN_NOT_READ;
        }
    }

    private void printErrorMessage() {
        output.printErrWhenInvalidDataTypeInput();
    }

    @Override
    public int inputHowManyTryTimes() {
        return inputUntilCorrectIntType();
    }
}
