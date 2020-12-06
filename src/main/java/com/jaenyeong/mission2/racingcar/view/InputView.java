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
        do {
            final int howManyUseCars = inputIntValue();

            // TODO 해당 지점을 인덴트 1로 줄이는 방법 찾기
            if (howManyUseCars != CAN_NOT_READ) {
                return howManyUseCars;
            }
        } while (true);
    }

    private int inputIntValue() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            printErrorMessage();
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
